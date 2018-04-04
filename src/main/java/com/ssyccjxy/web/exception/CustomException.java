package com.ssyccjxy.web.exception;

/**
 * Description: 自定义异常类
 * Cteated by wangpeng
 * 2018/3/31 1:32
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -6013645302905976487L;

    private Integer code;

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
