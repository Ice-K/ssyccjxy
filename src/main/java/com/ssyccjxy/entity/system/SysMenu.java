package com.ssyccjxy.entity.system;

import com.ssyccjxy.common.base.BaseEntity;
import com.ssyccjxy.web.util.tree.TreeEntity;

import java.util.List;

/**
 * Description：菜单实体类
 * Cteated by wangpeng
 * 2018/4/7 9:14
 */
public class SysMenu extends BaseEntity implements TreeEntity<SysMenu>{
    private static final long serialVersionUID = 2040375594763503504L;

    /** 主键id. */
    private Integer id;

    /** 上级id. */
    private Integer pid;

    /** 类型类型：0-菜单，1-按钮. */
    private Integer type;

    /** 名称. */
    private String name;

    /** 图标. */
    private String icon;

    /** 跳转的路径. */
    private String url;

    /** 权限字符串. */
    private String permission;

    /** 排序 */
    private Integer sort;

    /** 启用状态：0-未启用，1-启用. */
    private Integer start;

    private List<SysMenu> childList;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public List<SysMenu> getChildList() {
        return childList;
    }

    @Override
    public void setChildList(List<SysMenu> childList) {
        this.childList = childList;
    }
}
