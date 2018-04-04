package com.ssyccjxy.common.enums;

/**
 * Description：启用状态枚举
 * Cteated by wangpeng
 * 2018/3/31 14:48
 */
public enum StartEnum {

    NO_START(0, "未启用"),
    IS_START(1, "启用")
    ;

    /** 状态代码. */
    private Integer code;

    /** 信息. */
    private String msg;


    StartEnum(Integer code, String msg) {
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
