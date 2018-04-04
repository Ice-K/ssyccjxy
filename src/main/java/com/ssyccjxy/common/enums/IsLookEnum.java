package com.ssyccjxy.common.enums;

/**
 * Description：账号锁定状态枚举类
 * Cteated by wangpeng
 * 2018/3/31 15:04
 */
public enum IsLookEnum {
    NO_LOOK(0, "否"),
    IS_LOOK(1, "是"),
    ;

    /** 状态代码 */
    private Integer code;

    /** 说明信息 */
    private String msg;


    IsLookEnum(Integer code, String msg) {
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
