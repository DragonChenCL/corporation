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
    // 请求失败
    public static final int FAILED = 400;

    /*---------------------文章相关状态码--------------------------------*/
    // 超管--公告
    public static final String GONGGAO_ADMIN = "1000";
    // 超管--新闻
    public static final String NEWS_ADMIN = "1001";
    // 超管--法律
    public static final String LEGAL_ADMIN = "1002";
    // 超管--其他
    public static final String OTHERS_ADMIN = "1003";

    // 超管--公告
    public static final String GONGGAO_CORPORATION_ADMIN = "1100";
    // 超管--新闻
    public static final String NEWS_CORPORATION_ADMIN = "1101";
    // 超管--活动
    public static final String ACTIVITY_CORPORATION_ADMIN = "1102";
    // 超管--章程
    public static final String CHAPTER_CORPORATION_ADMIN = "1103";

}
