package com.itdage.entity;/**
 * Created by huayu on 2018/12/2.
 */

import java.io.Serializable;

/**
 * @ClassName Resource
 * @Description 权限类
 * @Author huayu
 * @Date 2018/12/2 11:51
 * @Version 1.0
 **/
public class Resource  implements Serializable {
    // 主键
    private int id;
    // 资源名
    private String title;
    // 资源的url
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
