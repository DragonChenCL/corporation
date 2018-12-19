package com.itdage.entity;/**
 * Created by huayu on 2018/11/29.
 */

/**
 * @ClassName Result
 * @Description 数据接口交互的类
 * @Author huayu
 * @Date 2018/11/29 20:22
 * @Version 1.0
 **/
public class Result {
    private int code;

    private String message;

    private Object data;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(){}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserController{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
