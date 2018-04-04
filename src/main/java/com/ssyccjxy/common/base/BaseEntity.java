package com.ssyccjxy.common.base;

import com.ssyccjxy.common.enums.IsDelEnum;

import java.io.Serializable;

/**
 * Description：基础Entity，包含所有实体类都含有的属性
 * Cteated by wangpeng
 * 2018/3/31 14:52
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8995031364034819446L;

    /** 创建时间. */
    private String createTime;

    /** 创建人. */
    private String createUser;

    /** 修改时间. */
    private String updateTime;

    /** 修改人. */
    private String updateUser;

    /** 是否被删除 0-有效，1-删除. */
    private Integer isDel = IsDelEnum.NO_DEL.getCode();


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
