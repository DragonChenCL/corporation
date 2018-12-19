package com.itdage.realm;

import com.itdage.entity.Resource;
import com.itdage.entity.Role;
import com.itdage.entity.User;
import com.itdage.service.ResourceService;
import com.itdage.service.RoleService;
import com.itdage.service.UserService;
import com.itdage.util.ConstantUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by huayu on 2018/11/28.
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

   /**
    * @description 授权的方法
    * @author xxx
    * @date 2018/11/28
    * @param principalCollection
    * @return org.apache.shiro.authz.AuthorizationInfo
    */
    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)principalCollection.getPrimaryPrincipal();
        if(ObjectUtils.isEmpty(user)){
            throw new AccountException("用户信息查询为空");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        List<Role> roleList = roleService.getListByParam(map);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if(roleList != null){
            roleList.forEach(role -> {
                List<Resource> resourceList = role.getResourceList();
                resourceList.forEach(resource -> {
                    authorizationInfo.addStringPermission(resource.getUrl());
                });
                authorizationInfo.addRole(role.getName());
            });
        }
        return authorizationInfo;
    }

    /**
     * @description 登录认证的方法
     * @author xxx
     * @date 2018/11/28
     * @param token
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        User user = userServiceImpl.findByUsername(username);
        if(user == null){
            return  null;
        }
        if (user.getValid() == 0){
            //账户锁定
            throw new LockedAccountException();
        }
        // 加入盐值加密
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        // session中不需要保存密码
        user.setPassword("");
        SecurityUtils.getSubject().getSession().setAttribute(ConstantUtil.TOKEN, user);
        return authenticationInfo;
    }
}
