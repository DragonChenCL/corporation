package com.itdage.dao;

import com.itdage.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by huayu on 2018/11/29.
 */
@Mapper
public interface UserDao extends CommonDao<User>{
    public User findByUsername(String userName);
}
