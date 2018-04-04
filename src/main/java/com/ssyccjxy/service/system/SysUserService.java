package com.ssyccjxy.service.system;

import com.ssyccjxy.entity.system.SysUser;

import java.util.List;

/**
 * Description：系统用户Service
 * Cteated by wangpeng
 * 2018/3/31 10:43
 */
public interface SysUserService {

    /**
     * 添加
     * @param user 添加的用户
     * @return int
     */
    int addUser(SysUser user);

    /**
     * 删除/批量删除 逻辑删除
     * @param ids 用户ids
     * @return int
     */
    int delUser(List<Integer> ids);

    /**
     * 超级删除/批量删除 物理删除
     * @return int
     */
    int delSupUser(List<Integer> ids);

    /**
     * 修改
     * @param user 修改后的用户信息
     * @return
     */
    int updateUser(SysUser user);


    /**
     * 修改密码
     * @param md5 加密后的密码
     * @param id 用户id
     * @return
     */
    int restPwd(String md5, Integer id);

    /**
     * 根据用户名查找用户信息
     * @param username 用户名
     * @return 用户信息
     */
    SysUser selectByUsername(String username);

    /**
     * 根据用户id查找用户信息
     * @param id 用户id
     * @return 用户信息
     */
    SysUser selectById(Integer id);


    /**
     * 根据条件查找用户信息
     * @param user 查询条件封装
     * @return 用户信息集合
     */
    List<SysUser> selectByParams(SysUser user);


}
