package com.ssyccjxy.web.jsonresult;

import com.ssyccjxy.common.enums.ResultEnum;

/**
 * Description: 封装返回的结果信息
 * Cteated by wangpeng
 * 2018/3/31 0:56
 */
public class JsonResult<T> {

    /**状态*/
    private int code;

    /**信息*/
    private String message;

    /**数据*/
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T date) {
        this.data = date;
    }
}
