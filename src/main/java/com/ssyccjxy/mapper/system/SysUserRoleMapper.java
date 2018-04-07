package com.ssyccjxy.mapper.system;

import com.ssyccjxy.entity.system.SysUserRole;
import org.apache.ibatis.annotations.*;

/**
 * Description：用户角色Mapper
 * Cteated by wangpeng
 * 2018/4/7 14:17
 */
@Mapper
public interface SysUserRoleMapper {

    @Insert("INSERT INTO sys_user_role (user_id, role_id) VALUES(#{userId}, #{roleId})")
    int insertUserRole(SysUserRole userRole);

    @Delete("DELETE FROM sys_user_role WHERE user_id = #{userId}")
    void deleteUserRole(@Param("userId") Integer userId);

}
