package com.itdage.entity;/**
 * Created by huayu on 2018/11/29.
 */

import com.itdage.util.ConstantUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<String, Object> map;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }



    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

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

    /**
     * @param message 返回的信息
     * @param data    返回的数据
     * @return com.itdage.entity.Result
     * @description 请求成功调用的方法
     * @author xxx
     * @date 2018/12/25
     */
    public static Result success(String message, Object data) {
        return new Result(ConstantUtil.SUCCESS, message, data);
    }

    /**
     * @param message 返回的信息
     * @return com.itdage.entity.Result
     * @description 请求成功调用的方法
     * @author xxx
     * @date 2018/12/25
     */
    public static Result success(String message) {
        return new Result(ConstantUtil.SUCCESS, message, null);
    }

    /**
     * @param message 返回的信息
     * @param map    返回的数据
     * @return com.itdage.entity.Result
     * @description 请求成功调用的方法
     * @author xxx
     * @date 2018/12/25
     */
    public static Map<String, Object> successMap(String message, Map<String, Object> map) {
        map.put("code", ConstantUtil.SUCCESS);
        map.put("message", message);
        return map;
    }

    /**
     * @param message 返回的信息
     * @param list    返回的数据列表
     * @param total   返回的数据总条数
     * @return map
     * @description 请求成功调用的方法
     * @author xxx
     * @date 2018/12/25
     */
    public static Map<String, Object> successMap(String message, List<?> list, int total) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", ConstantUtil.SUCCESS);
        map.put("tableData", list);
        map.put("total", total);
        map.put("message", message);
        return map;
    }

    /**
     * @param data
     * @return com.itdage.entity.Result
     * @description 请求失败时调用的方法
     * @author xxx
     * @date 2018/12/25
     */
    public static Result error(String message, Object data) {
        return new Result(ConstantUtil.FAILED, message, data);
    }

    /**
     * @param
     * @return com.itdage.entity.Result
     * @description 请求失败时调用的方法
     * @author xxx
     * @date 2018/12/25
     */
    public static Result error(String message) {
        return new Result(ConstantUtil.FAILED, message, null);
    }

    /**
     * @param data
     * @return com.itdage.entity.Result
     * @description 请求失败时调用的方法
     * @author xxx
     * @date 2018/12/25
     */
    public static Result error(String message, int code, Object data) {
        return new Result(code, message, data);
    }
    /**
     * @return com.itdage.entity.Result
     * @description 请求失败时调用的方法
     * @author xxx
     * @date 2018/12/25
     */
    public static Result
    error() {
        return new Result(ConstantUtil.FAILED, "操作失败！", null);
    }

    /**
     * @description 发生异常时的方法
     * @param
     * @author xxx
     * @return com.itdage.entity.Result
     * @date 2018/12/25
     */
    public static Result exception(int code) {
        return new Result(code, "内部异常!");
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
