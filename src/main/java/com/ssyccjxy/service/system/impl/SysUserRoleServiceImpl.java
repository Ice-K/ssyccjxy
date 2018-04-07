package com.ssyccjxy.service.system.impl;

import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.entity.system.SysUserRole;
import com.ssyccjxy.mapper.system.SysUserRoleMapper;
import com.ssyccjxy.service.system.SysUserRoleService;
import com.ssyccjxy.web.exception.CustomException;
import com.ssyccjxy.web.shiro.MyRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description：用户角色ServiceImpl
 * Cteated by wangpeng
 * 2018/4/7 15:55
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private MyRealm myRealm;


    @Override
    @Transactional
    public void updateUserRole(Integer userId, List<Integer> roleIds) {
        if (userId == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "添加失败, userId = null");
        }
        sysUserRoleMapper.deleteUserRole(userId);
        myRealm.clearCached();
        if (roleIds != null && roleIds.size()>0) {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            for (Integer id : roleIds) {
                userRole.setRoleId(id);
                int result = sysUserRoleMapper.insertUserRole(userRole);
                if (result < 1) {
                    throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "添加失败，系统异常");
                }
            }
        }
        myRealm.clearCached();
    }
}
