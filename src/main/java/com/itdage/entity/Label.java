package com.itdage.entity;/**
 * Created by huayu on 2018/12/12.
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @ClassName Label
 * @Description 构造权限列表
 * @Author huayu
 * @Date 2018/12/12 14:40
 * @Version 1.0
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Label {
    // 唯一标识
    private int id;
    // 显示名称
    private String label;
    // 子层级
    private List<Label> children;

    private List<Label> role;

    public List<Label> getRole() {
        return role;
    }

    public void setRole(List<Label> role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Label> getChildren() {
        return children;
    }

    public void setChildren(List<Label> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
