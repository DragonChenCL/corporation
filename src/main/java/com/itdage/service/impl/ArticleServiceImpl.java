package com.itdage.service.impl;/**
 * Created by huayu on 2018/12/24.
 */

import com.itdage.dao.ArticleDao;
import com.itdage.entity.Article;
import com.itdage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleServiceImpl
 * @Description
 * @Author huayu
 * @Date 2018/12/24 18:30
 * @Version 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public List<Article> selectAll() {
        return null;
    }

    @Override
    public int delete(Object param) {
        return articleDao.delete(param);
    }

    @Override
    public int add(Article obj) {
        return 0;
    }

    @Override
    public int update(Article obj) {
        return articleDao.update(obj);
    }

    @Override
    public List<Article> getListByParam(Map<String, Object> param) {
        return articleDao.getListByParam(param);
    }

}
