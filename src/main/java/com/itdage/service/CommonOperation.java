package com.itdage.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description 通用接口<br>包括增删改查
 * @author xxx
 * @date 2018/11/29
 * @param
 * @return
 */
@Service
public interface CommonOperation<T> {

    /**
     * @description 查询所有
     * @author xxx
     * @date 2018/11/29
     * @param
     * @return java.util.List<T>
     */
    public List<T> selectAll();

    /**
     * @description 删除一条数据
     * @author xxx
     * @date 2018/11/29
     * @param
     * @return int
     */
    public int delete(Object param);

    /**
     * @description 添加对象
     * @author xxx
     * @date 2018/11/29
     * @param
     * @return int
     */
    public int add(T obj);

    /**
     * @description 更新对象
     * @author xxx
     * @date 2018/11/29
     * @param
     * @return int
     */
    public int update(T obj);

    /**
     * @description 查询一个对象信息
     * @author xxx
     * @date 2018/11/29
     * @param
     * @return List<T>
     */
    public List<T> getListByParam(Map<String, Object> param);
}
