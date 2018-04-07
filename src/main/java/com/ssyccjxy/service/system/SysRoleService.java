package com.ssyccjxy.service.system;

import com.ssyccjxy.entity.system.SysRole;

import java.util.List;

/**
 * Description：角色信息Service
 * Cteated by wangpeng
 * 2018/4/7 11:51
 */
public interface SysRoleService {

    /** 添加. */
    int addSysRole(SysRole sysRole);

    /** 修改. */
    int updateSysRole(SysRole sysRole);

    /** 删除/批量删除，逻辑删除. */
    int deleteSysRole(String ids);

    /** 删除/批量删除，物理删除. */
    int deleteSupSysRole(String ids);

    /** 根据id查询角色信息. */
    SysRole selectOne(Integer id);

    /** 根据条件查询角色信息. */
    List<SysRole> selectList(SysRole sysRole);
}
