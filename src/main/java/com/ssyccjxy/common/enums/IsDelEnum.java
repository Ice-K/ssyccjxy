package com.ssyccjxy.common.enums;

/**
 * Description：删除标记枚举
 * Cteated by wangpeng
 * 2018/3/31 11:12
 */
public enum IsDelEnum {
    NO_DEL(0,"有效"),
    IS_DEL(1,"删除")
    ;

    private Integer code;
    private String msg;

    IsDelEnum(Integer code, String msg) {
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
