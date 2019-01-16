package com.itdage.entity;/**
 * Created by huayu on 2018/12/26.
 */

/**
 * @ClassName CommonEntity
 * @Description 通用的实体类 --- 工具类型
 * @Author huayu
 * @Date 2018/12/26 14:21
 * @Version 1.0
 **/
public class CommonEntity {
    // 类型 比如:增加还是编辑
    private int commonType;

    private int total;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCommonType() {
        return commonType;
    }

    public void setCommonType(int commonType) {
        this.commonType = commonType;
    }

}
