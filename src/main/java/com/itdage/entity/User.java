package com.itdage.entity;/**
 * Created by huayu on 2018/11/29.
 */

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName User
 * @Description 用户类
 * @Author huayu
 * @Date 2018/11/29 18:28
 * @Version 1.0
 **/
public class User implements Serializable{

    // 用户id
    private int id;
    //用户名
    private String username;
    //用户密码
    private String password;
    // 是否有效
    private int valid;
    //盐值
    private String salt;
    //角色
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", valid=" + valid +
                ", salt=" + salt +
                '}';
    }
}
