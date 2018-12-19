package com.itdage.service;

import com.itdage.entity.Label;
import com.itdage.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by huayu on 2018/12/2.
 */
@Service
@Transactional
public interface RoleService extends CommonOperation<Role>{
    public int updateHandle(Integer user, List<Label> roles);

    public int addRoles(Map<String, Object> map);
}
