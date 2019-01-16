package com.itdage.controller;/**
 * Created by Administrator on 2018/12/18 0018.
 */

import com.itdage.entity.Article;
import com.itdage.service.ArticleService;
import com.itdage.util.CommonMethodUtil;
import com.itdage.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

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

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommonMethodUtil commonMethodUtil;

    @RequestMapping("/index")
    public String home(HashMap<String, Object> map){
        HashMap<String, Object> map2 = new HashMap<>();
        // 超管发布的公告
        map2.put("type", ConstantUtil.GONGGAO_ADMIN);
        map2.put("count", null);
        map2.put("currentPage" , 1);
        map2.put("pageSize" , 10);
        commonMethodUtil.pageUitl(map2);
        List<Article> gongGaoList = articleService.getListByParam(map2);
        map2.put("type", ConstantUtil.NEWS_ADMIN);
        List<Article> news = articleService.getListByParam(map2);
        map2.put("type", ConstantUtil.LEGAL_ADMIN);
        List<Article> legal = articleService.getListByParam(map2);
        map2.put("type", ConstantUtil.OTHERS_ADMIN);
        List<Article> others = articleService.getListByParam(map2);
        map.put("gongGao", gongGaoList);
        map.put("news", news);
        map.put("legal", legal);
        map.put("others", others);
        map.put("ss", 11);
        map.put("username", "wp");
        map.put("username2", "scy");
        return "index";
    }
    @RequestMapping("/info")
    public String info(HashMap<String, Object> map){
        map.put("ss", 11);

        map.put("username", "wp");
        map.put("username2", "scy");
        return "info";
    }


}
