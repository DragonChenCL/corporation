package com.itdage.controller;/**
 * Created by Administrator on 2018/12/18 0018.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/18 0018 上午 7:11
 * @Version 1.0
 **/
@Controller
@RequestMapping("/home")
public class IndexController {

    @RequestMapping("/index")
    public String home(HashMap<String, Object> map){

        map.put("username", "wp");
        map.put("username2", "scy");
        return "index";
    }
}
