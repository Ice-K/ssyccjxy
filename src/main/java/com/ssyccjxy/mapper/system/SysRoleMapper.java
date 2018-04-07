package com.ssyccjxy.mapper.system;

import com.ssyccjxy.entity.system.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Description：角色Mapper
 * Cteated by wangpeng
 * 2018/3/31 17:00
 */
@Mapper
public interface SysRoleMapper {

    /** 添加角色 */
    @InsertProvider(type = SysRoleProvider.class, method = "insertSql")
    int insertRole(SysRole sysRole);

    /** 删除角色，逻辑删除 */
    @Update("UPDATE sys_role SET is_del = 1 Where id IN (${ids})")
    int deleteByIds(@Param("ids") String ids);

    /** 删除角色, 物理删除 */
    @Delete("DELETE FROM sys_user WHERE ids IN (${ids})")
    int deleteSupByIds(@Param("ids") String ids);

    /** 修改角色 */
    @UpdateProvider(type = SysRoleProvider.class, method = "updateSql")
    int updateById(SysRole sysRole);


    /** 根据id查询角色 */
    @Select("SELECT * FROM sys_role WHERE is_del = 0 AND id = #{id}")
    @Results(id = "resultMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "description", column = "description"),
            @Result(property = "isDel", column = "is_del"),
            @Result(property = "start", column = "start"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "updateUser", column = "update_user")
    })
    SysRole selectById(@Param("id") Integer id);

    /** 根据条件查询角色 */
    @SelectProvider(type = SysRoleProvider.class, method = "selectSql")
    @ResultMap("resultMap")
    List<SysRole> selectByParams(SysRole sysRole);

    /** 根据用户id查找用户个数，用来判断用户是否存在 */
    @Select("SELECT COUNT(*) FROM sys_role WHERE is_del = 0 AND id = #{id}")
    int selectTotalById(@Param("id") Integer id);
}
