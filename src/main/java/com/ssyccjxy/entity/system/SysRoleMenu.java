package com.ssyccjxy.entity.system;

import com.ssyccjxy.common.base.BaseEntity;

/**
 * Description：角色和菜单关系实体
 * Cteated by wangpeng
 * 2018/4/7 10:34
 */
public class SysRoleMenu extends BaseEntity {


    private static final long serialVersionUID = 8070397853058632355L;

    /** 主键id. */
    private Integer id;

    /** 角色id. */
    private Integer roleId;

    /** 菜单id. */
    private Integer menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
