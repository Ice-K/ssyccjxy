package com.ssyccjxy.entity.system.dto;

import com.ssyccjxy.common.base.BaseEntity;
import com.ssyccjxy.common.enums.IsLookEnum;
import com.ssyccjxy.common.enums.OnJobEnum;
import com.ssyccjxy.entity.system.SysMenu;

import java.util.List;

/**
 * Description：
 * Cteated by wangpeng
 * 2018/4/7 9:12
 */
public class SysUserInfo extends BaseEntity {
    private static final long serialVersionUID = -27910734544075749L;

    /**用户id*/
    private Integer id;

    /** 上级领导id. */
    private Integer pid;

    /** 部门id. */
    private Integer deptId;

    /** 部门名称. */
    private String deptName;

    /** 登录名. */
    private String username;

    /** 密码. */
    private String password;

    /** 真实姓名. */
    private String realName;

    /** 手机号. */
    private String phone;

    /** 最后一次登录时间. */
    private String lastLoginTime;

    /** 最后一次登录ip. */
    private String lastLoginIp;

    /** 最后一次登录地址. */
    private String lastLoginAdd;

    /** 是否为领导. */
    private Integer head;

    /** 账号是否为锁定 0-否，1-是. */
    private Integer isLook = IsLookEnum.NO_LOOK.getCode();

    /** 状态：0-在职，1-离职. 2-复职. */
    private Integer onJob = OnJobEnum.ON_JOB.getCode();

    /** 用户所拥有的菜单. */
    private List<SysMenu> Menus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginAdd() {
        return lastLoginAdd;
    }

    public void setLastLoginAdd(String lastLoginAdd) {
        this.lastLoginAdd = lastLoginAdd;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getIsLook() {
        return isLook;
    }

    public void setIsLook(Integer isLook) {
        this.isLook = isLook;
    }

    public Integer getOnJob() {
        return onJob;
    }

    public void setOnJob(Integer onJob) {
        this.onJob = onJob;
    }

    public List<SysMenu> getMenus() {
        return Menus;
    }

    public void setMenus(List<SysMenu> menus) {
        Menus = menus;
    }
}
