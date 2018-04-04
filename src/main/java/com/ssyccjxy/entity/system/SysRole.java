package com.ssyccjxy.entity.system;

import com.ssyccjxy.common.base.BaseEntity;
import com.ssyccjxy.common.enums.StartEnum;

/**
 * Description：角色信息实体类
 * Cteated by wangpeng
 * 2018/3/31 14:39
 */
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = -1316109113589717608L;
    /** 角色主键id. */
    private Integer id;

    /** 角色名称. */
    private String name;

    /** 角色代码. */
    private String code;

    /** 角色说明. */
    private String description;

    /** 启用状态：0-未启用，1-启用. */
    private Integer start = StartEnum.NO_START.getCode();



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

}
