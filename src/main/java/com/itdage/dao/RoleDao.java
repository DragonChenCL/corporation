package com.itdage.dao;

import com.itdage.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by huayu on 2018/12/2.
 */
@Mapper
public interface RoleDao extends CommonDao<Role>{
    public int addRoles(Map<String, Object> map);
}
