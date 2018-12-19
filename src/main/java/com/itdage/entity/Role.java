package com.itdage.entity;/**
 * Created by huayu on 2018/12/2.
 */

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Role
 * @Description 角色类
 * @Author huayu
 * @Date 2018/12/2 11:40
 * @Version 1.0
 **/
public class Role implements Serializable{
    // 主键
    private int id;
    // 角色名
    private String name;
    // 角色描述
    private String des;
    // 此角色拥有的资源列表
    private List<Resource> resourceList;

    private int user_id;

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + des + '\'' +
                ", resourceList=" + resourceList +
                '}';
    }
}
