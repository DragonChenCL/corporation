package com.itdage.service.impl;/**
 * Created by huayu on 2018/11/29.
 */

import com.itdage.dao.UserDao;
import com.itdage.entity.User;
import com.itdage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author huayu
 * @Date 2018/11/29 18:51
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public int delete(Object param) {
        return 0;
    }

    @Override
    public int add(User obj) {
        return 0;
    }

    @Override
    public int update(User obj) {
        return 0;
    }

    @Override
    public List<User> getListByParam(Map<String, Object> param) {
        return null;
    }

}
