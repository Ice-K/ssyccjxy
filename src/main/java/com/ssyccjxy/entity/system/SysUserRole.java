package com.ssyccjxy.entity.system;

import com.ssyccjxy.common.base.BaseEntity;

/**
 * Description：用户角色对应关系实体
 * Cteated by wangpeng
 * 2018/4/7 10:31
 */
public class SysUserRole extends BaseEntity{

    private static final long serialVersionUID = -222877955332643608L;
    /** 主键id. */
    private Integer id;

    /** 用户id. */
    private Integer userId;

    /** 角色id. */
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
