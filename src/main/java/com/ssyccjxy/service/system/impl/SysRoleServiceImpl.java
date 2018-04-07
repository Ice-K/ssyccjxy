package com.ssyccjxy.service.system.impl;

import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.entity.system.SysRole;
import com.ssyccjxy.mapper.system.SysRoleMapper;
import com.ssyccjxy.service.system.SysRoleService;
import com.ssyccjxy.web.exception.CustomException;
import com.ssyccjxy.web.shiro.MyRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description：角色信息ServiveImpl
 * Cteated by wangpeng
 * 2018/4/7 11:55
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private MyRealm myRealm;

    @Override
    @Transactional
    public int addSysRole(SysRole sysRole) {
        if (sysRole == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "sysRole = null");
        }
        int result = sysRoleMapper.insertRole(sysRole);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "添加失败，系统异常");
        }
        return result;
    }

    @Override
    @Transactional
    public int updateSysRole(SysRole sysRole) {
        if (sysRole == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "sysRole = null");
        }
        if (sysRole.getId() == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "sysRole-->id = null");
        }
        int result = sysRoleMapper.updateById(sysRole);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "修改失败，系统异常");
        }
        myRealm.clearCached();
        return result;
    }

    @Override
    @Transactional
    public int deleteSysRole(List<Integer> ids) {
        if (ids == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "ids = null");
        }
        int result = sysRoleMapper.deleteByIds(ids);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "删除失败，系统异常");
        }
        myRealm.clearCached();
        return result;
    }

    @Override
    @Transactional
    public int deleteSupSysRole(List<Integer> ids) {
        if (ids == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "ids = null");
        }
        int result = sysRoleMapper.deleteSupByIds(ids);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "删除失败，系统异常");
        }
        myRealm.clearCached();
        return result;
    }

    @Override
    public SysRole selectOne(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "id = null");
        }
        SysRole role = sysRoleMapper.selectById(id);
        if (role == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "用户不存在");
        }
        return role;
    }

    @Override
    public List<SysRole> selectList(SysRole sysRole) {
        return sysRoleMapper.selectByParams(sysRole);
    }
}
