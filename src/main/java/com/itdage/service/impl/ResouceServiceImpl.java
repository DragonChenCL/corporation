package com.itdage.service.impl;/**
 * Created by huayu on 2018/12/2.
 */

import com.itdage.entity.Resource;
import com.itdage.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ResouceServiceImpl
 * @Description
 * @Author huayu
 * @Date 2018/12/2 11:54
 * @Version 1.0
 **/
@Service
public class ResouceServiceImpl  implements ResourceService{
    @Override
    public List<Resource> selectAll() {
        return null;
    }

    @Override
    public int delete(Object param) {
        return 0;
    }

    @Override
    public int add(Resource obj) {
        return 0;
    }

    @Override
    public int update(Resource obj) {
        return 0;
    }

    @Override
    public List<Resource> getListByParam(Map<String, Object> param) {
        return null;
    }
}
