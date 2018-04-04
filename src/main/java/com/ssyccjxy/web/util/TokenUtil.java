package com.ssyccjxy.web.util;

import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.entity.system.SysUser;
import com.ssyccjxy.web.exception.CustomException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;


/**
 * Description：Shiro管理下的Token工具类
 * Cteated by wangpeng
 * 2018/4/3 10:22
 */
public class TokenUtil {

    /**
     * 登录
     * @param user 用户名密码封装类
     * @param rememberMe 是否记住我
     * @return
     */
    public static SysUser login(SysUser user, boolean rememberMe) {
        if (!StringUtil.isNotBlank(user.getUsername()) || !StringUtil.isNotBlank(user.getPassword())) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "请输入用户名或密码");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername().trim(), user.getPassword().trim());
        token.setRememberMe(rememberMe);
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "用户名不存在");
        } catch (IncorrectCredentialsException ice) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "密码错误");
        } catch (LockedAccountException lae) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "您已被锁定，请联系管理员解锁");
        } catch (ExcessiveAttemptsException eae) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "错误次数过多");
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
        }
        return getUser();
    }

    public static SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }
}
