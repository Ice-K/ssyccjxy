package com.ssyccjxy.common.enums;

/**
 * Description：是否为领导枚举类 是否为负责人：0-否，1-是
 * Cteated by wangpeng
 * 2018/3/31 17:24
 */
public enum HeadEnum {
    ON_HEAD(0, "否"),
    IS_HEAD(1, "是")
    ;


    private Integer code;

    private String msg;

    HeadEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
