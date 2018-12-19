package com.itdage.service;

import com.itdage.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by huayu on 2018/11/29.
 */
@Service
public interface UserService extends CommonOperation<User>{

    public User findByUsername(String userName);
}
