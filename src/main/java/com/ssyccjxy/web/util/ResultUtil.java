package com.ssyccjxy.web.util;

import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.web.jsonresult.JsonResult;

/**
 * Description: 结果工具类
 * Cteated by wangpeng
 * 2018/3/31 0:59
 */
public class ResultUtil {

    /**
     * 成功 没有数据
     */
    public static JsonResult success(String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ResultEnum.SUCCESS.getCode());
        jsonResult.setMessage(message);
        jsonResult.setData(null);
        return jsonResult;
    }

    /**
     * 成功 有数据
     */
    public static JsonResult success(Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ResultEnum.SUCCESS.getCode());
        jsonResult.setMessage(ResultEnum.SUCCESS.getMsg());
        jsonResult.setData(data);
        return jsonResult;
    }


    /**
     * 失败 没有数据
     */
    public static JsonResult error(Integer code, String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMessage(msg);
        jsonResult.setData(null);
        return jsonResult;
    }

}
