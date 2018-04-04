package com.ssyccjxy.web.shiro;

import com.ssyccjxy.web.util.MD5Util;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Description：自定义Shiro凭证匹配器
 * Cteated by wangpeng
 * 2018/3/30 9:22
 */
public class MD5CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;

        String pwd = String.valueOf(token.getPassword());
        String accountCredentials = String.valueOf(getCredentials(info));
        return MD5Util.matcher(pwd,accountCredentials);
    }
}
