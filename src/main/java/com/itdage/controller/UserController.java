package com.itdage.controller;/**
 * Created by huayu on 2018/11/29.
 */

import com.itdage.entity.*;
import com.itdage.realm.MyShiroRealm;
import com.itdage.service.RoleService;
import com.itdage.service.UserService;
import com.itdage.util.ConstantUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @ClassName UserController
 * @Description
 * @Author huayu
 * @Date 2018/11/29 20:21
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MyShiroRealm myShiroRealm;
    @Autowired
    private RoleService roleService;


    public UserController(MyShiroRealm myShiroRealm){
        this.myShiroRealm = myShiroRealm;
    }

    //日志
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 判断用户是否已经登录
     *
     * @param user
     * @return
     */
    public boolean isRelogin(User user) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return true; //参数未改变,无需重新登录,默认为已登录成功
        }
        return false;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result shiroLogin(@RequestBody User user) {
        Result result = null;
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(true);
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            logger.error("账号不存在" + e);
            return new Result(ConstantUtil.ACCOUNT_EROOR, "用户名或密码不正确!");
        } catch (IncorrectCredentialsException e) {
            logger.error("密码不正确" + e);
            return new Result(ConstantUtil.ACCOUNT_EROOR, "用户名或密码不正确!");
        } catch (LockedAccountException e) {
            logger.error("账号被锁定" + e);
            return new Result(ConstantUtil.ACCOUNT_LOCKED, "用户账号被锁定!");
        } catch (AuthenticationException e) {
            logger.error("登录失败" + e);
            return new Result(ConstantUtil.LOGIN_ERROR, "登录失败");
        }
        // 登录成功
        Session session = SecurityUtils.getSubject().getSession();
        logger.info("用户" + user.getUsername() + ",sessionId:" + session.getId() + "登录成功");

        return new Result(ConstantUtil.SUCCESS, "登录成功!", session.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public Result getUserInfo(@RequestBody String token) {
        // 构造返回的data
        HashMap<String, Object> map2 = new HashMap<>();
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User)session.getAttribute(ConstantUtil.TOKEN);
        List<String> roleList = (List<String>) session.getAttribute(ConstantUtil.ROLE);
        List<String> permissionList = (List<String>) session.getAttribute(ConstantUtil.PERMISSION);
        if(roleList == null){
            HashMap<String, Object> map = new HashMap<>();
            map.put("username", user.getUsername());
            List<Role> list = roleService.getListByParam(map);
            List<String> roleArray = new ArrayList<>();
            List<String> permissionArray = new ArrayList<>();
            if(list != null){
                list.forEach(role -> {
                    List<Resource> resourceList = role.getResourceList();
                    resourceList.forEach(resource -> {
                        permissionArray.add(resource.getUrl());
                    });
                    roleArray.add(role.getName());
                });
            }
            session.setAttribute(ConstantUtil.ROLE, roleArray);
            session.setAttribute(ConstantUtil.PERMISSION, permissionArray);
            map2.put("roles", roleArray);
            map2.put("permission", permissionArray);
        }else {
            map2.put("roles", roleList);
            map2.put("permission", permissionList);
        }
        map2.put("name", user.getUsername());
        map2.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map2.put("introduction", "介绍");
        Result result = new Result(200, ConstantUtil.SUCCESS_MESSAGE);
        result.setData(map2);
        return result;
    }

    /**
     * @description 获取所有用户信息，admin有这个权限
     * @author xxx
     * @date 2018/12/10
     * @param
     * @return com.itdage.entity.Result
     */
    // @RequiresRoles(value = {"admin", "user"}, logical = Logical.OR)
    // @RequiresRoles(value = {"admin", "user"}, logical = Logical.AND)
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    @RequiresRoles(value = {"admin"})
    public Result getUserInfo2() {
        Result result = new Result(200, "获取成功!");
        List<User> userList = userService.selectAll();
        Label label = new Label();
        label.setId(000000);
        label.setLabel("系统用户");
        ArrayList<Label> labelArrayList = new ArrayList<>();
        userList.forEach(user -> {
            if("admin".equals(user.getUsername())){
                return;
            }else {
                ArrayList<Label> roleList = new ArrayList<>();
                Label label2 = new Label();
                label2.setId(user.getId());
                label2.setLabel(user.getUsername());
                user.getRoleList().forEach(role -> {
                    Label label3 = new Label();
                    label3.setId(role.getId());
                    label3.setLabel(role.getDes());
                    roleList.add(label3);
                });
                label2.setRole(roleList);
                labelArrayList.add(label2);
            }
        });
        label.setChildren(labelArrayList);
        ArrayList<Label> label2 = new ArrayList<>();
        label2.add(label);
        result.setData(label2);
        return result;
    }

}
