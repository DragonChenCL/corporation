package com.itdage.entity;/**
 * Created by huayu on 2018/12/24.
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName Article
 * @Description
 * @Author huayu
 * @Date 2018/12/24 18:29
 * @Version 1.0
 **/
public class Article extends CommonEntity{

    private int id;

    // 标题
    private String title;

    // 发布人
    private String author;

    // 发布时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishDate;

    // 内容
    private String content;

    // 简写内容--截取30字符
    private String subContent;

    // 类型
    private String type;

    // 类型名称
    private String typeName;

    // 操作人
    private String token;

    // 总数量
//    private int total;
//
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                ", content='" + content + '\'' +
                ", subContent='" + subContent + '\'' +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public String getSubContent() {
        return subContent;
    }

    public void setSubContent(String subContent) {
        this.subContent = subContent;
    }

}
