package com.ssyccjxy.web.shiro;

import com.ssyccjxy.common.constant.Constants;
import com.ssyccjxy.web.util.PropertiesUtil;
import com.ssyccjxy.web.util.StringUtil;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Description：配置自定义的form表单验证
 * Cteated by wangpeng
 * 2018/3/30 16:05
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        boolean flag = Boolean.valueOf(PropertiesUtil.getProperty("shiro.imgCodeFlag"));
        if (flag) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpSession session = httpServletRequest.getSession();
            String sessionValidateCode = (String) session.getAttribute(Constants.SESSION_VALIDATE_CODE_KEY);
            String inputValidateCode = httpServletRequest.getParameter(Constants.REQUEST_VALIDATE_CODE_KEY);

            if (sessionValidateCode != null && inputValidateCode != null && !sessionValidateCode.equalsIgnoreCase(inputValidateCode)) {
                httpServletRequest.setAttribute(Constants.SHIRO_LOGIN_FAILURE, Constants.VALIDATE_CODE_ERROR);
                //拒绝访问
                return true;
            }
            session.removeAttribute(Constants.SESSION_VALIDATE_CODE_KEY);
        }


        return super.onAccessDenied(request, response);
    }
}
