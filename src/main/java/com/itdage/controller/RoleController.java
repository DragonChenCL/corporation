package com.itdage.controller;/**
 * Created by Administrator on 2018/12/12 0012.
 */

import com.google.gson.Gson;
import com.itdage.entity.Label;
import com.itdage.entity.Result;
import com.itdage.entity.Role;
import com.itdage.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleController
 * @Description 角色操作类
 * @Author Administrator
 * @Date 2018/12/12 0012 下午 9:28
 * @Version 1.0
 **/
@Controller
@RequestMapping("/role")
public class RoleController {
//
//    @Autowired
//    private RoleService roleService;
//
//    @RequiresRoles(value = {"admin"})
//    @RequestMapping("/getAllRoles")
//    @ResponseBody
//    public Result getAllRole(){
//        Result result = new Result(200, "请求成功!");
//        List<Role> roleList = roleService.selectAll();
//        Label label = new Label();
//        label.setId(000000);
//        label.setLabel("系统角色");
//        ArrayList<Label> labelArrayList = new ArrayList<>();
//        roleList.forEach(role -> {
//            Label label2 = new Label();
//            label2.setId(role.getId());
//            label2.setLabel(role.getDes());
//            labelArrayList.add(label2);
//        });
//        label.setChildren(labelArrayList);
//        ArrayList<Label> label2 = new ArrayList<>();
//        label2.add(label);
//        result.setData(label2);
//        System.out.println(result);
//        return result;
//    }
//
//    @ResponseBody
//    @RequiresRoles(value = {"admin"})
//    @RequestMapping(value = "/updateRoles", method = RequestMethod.PUT)
//    public Result updateRoles(@RequestBody Map map){
//        Result result = new Result();
//        int user = Integer.parseInt(map.get("user") + "");
//        List<Label> roleIds2 = (List<Label>) map.get("roleIds");
//        System.out.println("更新" + user + roleIds2);
//        roleService.updateHandle(user, roleIds2);
//        return result;
//    }


}
