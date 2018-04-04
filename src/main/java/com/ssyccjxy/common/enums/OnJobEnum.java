package com.ssyccjxy.common.enums;

/**
 * Description：在职状态枚举类
 * Cteated by wangpeng
 * 2018/3/31 15:12
 */
public enum OnJobEnum {
    ON_JOB(0, "在职"),
    LE_JOB(1, "离职"),
    FU_JOB(2, "复制")
    ;

    /** 在职状态码 */
    private Integer code;

    /**说明*/
    private String msg;

    OnJobEnum(Integer code, String msg) {
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
