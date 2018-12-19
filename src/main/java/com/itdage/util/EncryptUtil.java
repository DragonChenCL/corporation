package com.itdage.util;/**
 * Created by huayu on 2018/12/2.
 */

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName EncryptUtil
 * @Description 加密工具类
 * @Author huayu
 * @Date 2018/12/2 10:32
 * @Version 1.0
 **/
public class EncryptUtil {

    // 加密策略 MD5加密
    private static final String ALGORITH_NAME = "MD5";
    //加密次数
    private static final int HASH_ITERATIONS = 1;

    /**
     * @description 加密算法 依托shiro的加密工具类
     * @author xxx
     * @date 2018/12/2
     * @param password 加密前的密码--明文
     * @param salt 盐值
     * @return java.lang.String 加密后的数据--密文
     */
    public static String encrypt(String password, String salt) {
        password = new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(salt), HASH_ITERATIONS).toHex();
        return password;
    }

//    public static void main(String[] args) {
//        String encrypt = encrypt("123456", "123456");
//        System.out.println(encrypt);
//    }
}
