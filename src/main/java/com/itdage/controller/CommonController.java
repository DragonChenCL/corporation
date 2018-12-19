package com.itdage.controller;/**
 * Created by huayu on 2018/12/11.
 */

import com.itdage.entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName CommonController
 * @Description 通用页面Controller  404 500 error
 * @Author huayu
 * @Date 2018/12/11 10:01
 * @Version 1.0
 **/
@Controller
public class CommonController {

    @RequestMapping("/unauth")
    public void errorPage(){
        System.out.println("无权限页面");
        return;
    }
}
