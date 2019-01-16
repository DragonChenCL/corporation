package com.itdage.dao;

import com.itdage.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by huayu on 2018/12/24.
 */
@Mapper
@Component
public interface ArticleDao extends CommonDao<Article> {

}
