package com.ssyccjxy.common.enums;

/**
 * Description: 返回结果状态枚举
 * Cteated by wangpeng
 * 2018/3/31 1:06
 */
public enum ResultEnum {

    SUCCESS(1, "成功"),
    ERROR(2, "失败"),
    SYS_SERVER_ERROR(3, "系统异常")
    ;

    private int code;
    private String msg;


    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
