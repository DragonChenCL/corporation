package com.itdage.service.impl;/**
 * Created by huayu on 2018/12/2.
 */

import com.itdage.dao.RoleDao;
import com.itdage.entity.Label;
import com.itdage.entity.Role;
import com.itdage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleServiceImpl
 * @Description
 * @Author huayu
 * @Date 2018/12/2 11:43
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> selectAll() {
        return roleDao.selectAll();
    }

    @Override
    public int delete(Object param) {
        return roleDao.delete(param);
    }

    @Override
    public int add(Role obj) {
        return 0;
    }

    @Override
    public int update(Role obj) {
        return 0;
    }

    @Override
    public List<Role> getListByParam(Map<String, Object> param) {
        return roleDao.getListByParam(param);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHandle(Integer userId, List<Label> roles) {
        if (userId == null || roles == null){
            return 0;
        }
        delete(userId);
        System.out.println(1/0);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("roleIds", roles);
        return addRoles(map);
    }

    @Override
    public int addRoles(Map<String, Object> map) {
        return roleDao.addRoles(map);
    }
}
