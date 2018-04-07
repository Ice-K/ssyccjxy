package com.ssyccjxy.web.controller.system;

import com.ssyccjxy.common.constant.Constants;
import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.web.exception.CustomException;
import com.ssyccjxy.web.util.ImgCodeUtil;
import com.ssyccjxy.web.util.PropertiesUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description：登录相关Controller
 * Cteated by wangpeng
 * 2018/4/3 9:46
 */
@Controller
public class LoginController {


    @RequestMapping("/login")
    public String doLogin(HttpServletRequest request) {

        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute(Constants.SHIRO_LOGIN_FAILURE);
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
                throw new CustomException(ResultEnum.ERROR.getCode(),"账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                throw new CustomException(ResultEnum.ERROR.getCode(),"用户名/密码错误");
            } else if(Constants.VALIDATE_CODE_ERROR.equals(exceptionClassName)){
                throw new CustomException(ResultEnum.ERROR.getCode(),"验证码错误 ");
            } else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
                throw new CustomException(ResultEnum.ERROR.getCode(), "账号被锁定，请联系管理员解锁");
            } else {
                throw new RuntimeException();//最终在异常处理器生成未知错误
            }
        }
        //此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
        //登陆失败还到login页面
        return "login";
    }

    @GetMapping(value = "/imgCode")
    public void getImgCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imageCode = ImgCodeUtil.outputVerifyImage(67, 23, response.getOutputStream(), 5);
        request.getSession().setAttribute(Constants.SESSION_VALIDATE_CODE_KEY, imageCode);
    }
}
