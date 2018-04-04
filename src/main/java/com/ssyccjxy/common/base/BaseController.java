package com.ssyccjxy.common.base;

import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.web.exception.CustomException;
import com.ssyccjxy.web.jsonresult.JsonResult;
import com.ssyccjxy.web.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Description: controller全局异常处理
 * Cteated by wangpeng
 * 2018/3/31 0:53
 */
@ControllerAdvice
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//500错误
    public JsonResult exceptionHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        if ( ex instanceof CustomException) {
            CustomException ce = (CustomException) ex;
            return ResultUtil.error(ce.getCode(), ce.getMessage());
        } else {
            StringWriter trace = new StringWriter();
            ex.printStackTrace(new PrintWriter(trace));
            LOGGER.error(trace.toString());
            return ResultUtil.error(ResultEnum.SYS_SERVER_ERROR.getCode(), ResultEnum.SYS_SERVER_ERROR.getMsg());
        }
    }
}
