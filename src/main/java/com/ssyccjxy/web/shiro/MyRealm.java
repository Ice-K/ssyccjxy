package com.ssyccjxy.web.shiro;

import com.ssyccjxy.common.enums.IsLookEnum;
import com.ssyccjxy.entity.system.SysMenu;
import com.ssyccjxy.entity.system.SysUser;
import com.ssyccjxy.entity.system.dto.SysMenuDto;
import com.ssyccjxy.entity.system.dto.SysUserInfo;
import com.ssyccjxy.service.system.SysUserService;
import com.ssyccjxy.web.util.tree.TreeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description：自定义realm 用户认证/授权
 * Cteated by wangpeng
 * 2018/3/29 15:53
 */
@Component
public class MyRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    private SysUserService sysUserService;

    @Override
    public String getName() {
        return super.getName();
    }


    //支持UsernamePasswordToken
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 认证
     * @param authenticationToken 用户输入的令牌
     * @return info 用户信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //1.从authenticationToken中取出用户输入的用户名
        String username = (String) authenticationToken.getPrincipal();
        log.info("登录用户名：username ===> " + username);
        //2.根据username 从数据库中查询出用户信息
        SysUser user = sysUserService.selectByUsername(username);
        if (user == null) {
            return null;
        }
        if (user.getIsLook().equals(IsLookEnum.IS_LOOK.getCode())) {
            throw new LockedAccountException();
        }
        SysUserInfo userInfo = new SysUserInfo();
        BeanUtils.copyProperties(user, userInfo);
        List<SysMenu> menus = TreeUtil.getTree(null, sysUserService.selectMenuById(user.getId()));
        userInfo.setMenus(menus);
        return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), getName());
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //1.从principals中获取主分身信息，账号
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        //2.从数据库中查询当前用户所拥有的权限信息
        Set<String> userRole = sysUserService.selectRoleById(user.getId());
        Set<String> userPermissions = sysUserService.selectPermissionById(user.getId());
        List<String> permissions = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        for (String str : userPermissions) {
            if (StringUtils.isNotBlank(str)) {
                permissions.add(str.trim());
            }
        }
        for (String str : userRole) {
            if (StringUtils.isNotBlank(str)) {
                roles.add(str.trim());
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        info.addRoles(roles);
        return info;
    }

    /**
     * 清除缓存,此方法必须在service中修改，删除权限信息的时候调用
     */
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}
