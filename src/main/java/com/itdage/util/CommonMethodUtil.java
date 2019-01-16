package com.itdage.util;/**
 * Created by huayu on 2018/12/29.
 */

import com.itdage.entity.Role;
import com.itdage.entity.User;
import com.itdage.realm.MyShiroRealm;
import com.itdage.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName CommonUtil
 * @Description 放置一些通用的方法
 * @Author huayu
 * @Date 2018/12/29 19:53
 * @Version 1.0
 **/
@Component
public class CommonMethodUtil {

    //日志
    private static Logger logger = LoggerFactory.getLogger(CommonMethodUtil.class);

    /**
     * @description 验证出错通用方法
     * @author xxx
     * @date 2018/12/29
     * @param bindingResult
     * @return java.lang.Boolean
     */
    public static Boolean validError(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            List<String> mesList=new ArrayList<String>();
            for (int i = 0; i < errorList.size(); i++) {
                mesList.add(errorList.get(i).getDefaultMessage());
            }
            logger.error("错误信息:" + mesList);
            return true;
        }
        return false;
    }


    /**
     * @description 分页的公共方法
     * @author xxx
     * @date 2018/12/30
     * @param map
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> pageUitl(Map<String, Object> map){
        Integer currentPage = (Integer) map.get("currentPage");
        Integer pageSize = (Integer) map.get("pageSize");
        map.put("currentPage", (currentPage - 1) * pageSize);
        return map;
    }


    /**
     * @description 获取当前登录用户
     * @author xxx
     * @date 2019/1/4
     * @return com.itdage.entity.User
     */
    public User getCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user;
    }




    /**
     * @description 获取当前用户角色
     * @author xxx
     * @date 2019/1/8
     * @return java.util.List<com.itdage.entity.Role>
     */
    public List<Role> getCurrentUserRoles(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user.getRoleList();
    }

    /**
     * @description 获取年月日格式字符串
     * @author xxx
     * @date 2019/1/14
     * @param date 时间
     * @return String
     */
    public static String getYMD(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        return s;
    }
}
