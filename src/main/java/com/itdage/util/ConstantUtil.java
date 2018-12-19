package com.itdage.util;/**
 * Created by huayu on 2018/11/29.
 */

/**
 * @ClassName ConstantUtil
 * @Description 常量类 配置常用的状态码
 * @Author huayu
 * @Date 2018/11/29 20:46
 * @Version 1.0
 **/
public class ConstantUtil {

    // 内部逻辑错误
    public static final int INNER_ERROR = 500;
    // 不存在
    public static final int NOT_EXISTENT = 404;
    // 用户名或密码不正确
    public static final int ACCOUNT_EROOR = 405;
    // 账号被锁定
    public static final int ACCOUNT_LOCKED = 406;
    // 登录失败--可能是服务器逻辑错误
    public static final int LOGIN_ERROR = 407;
    // 登录失败--未登录就访问
    public static final int ACCESS_ERROR = 408;
    // 成功
    public static final int SUCCESS = 200;
    // 成功_message
    public static final String SUCCESS_MESSAGE = "请求成功!";
    // 用户标识
    public static final String TOKEN = "token";
    // 角色标识
    public static final String ROLE = "role";
    // 权限标识
    public static final String PERMISSION = "permission";

}
