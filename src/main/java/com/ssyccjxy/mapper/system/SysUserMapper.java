package com.ssyccjxy.mapper.system;

import com.ssyccjxy.entity.system.SysMenu;
import com.ssyccjxy.entity.system.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface SysUserMapper {




    /** 删除用户，逻辑删除 */
    @Update("UPDATE sys_user SET is_del = 1 WHERE id IN (${ids})")
    int deleteByIds(@Param("ids") List<Integer> ids);

    /** 删除用户，物理删除 */
    @Delete("DELETE FROM sys_user WHERE id IN (${ids})")
    int deleteSupByIds(@Param("ids") List<Integer> ids);

    /** 添加用户 */
    @InsertProvider(type = SysUserProvider.class, method = "insertSql")
    int insert(SysUser user);

    /** 根据id查找用户 */
    @Select("SELECT * FROM sys_user WHERE is_del = 0 and id = #{id}")
    SysUser selectById(@Param("id") Integer id);

    /** 修改用户 */
    @UpdateProvider(type = SysUserProvider.class, method = "updateByIdSql")
    int updateById(SysUser record);

    /** 根据条件查找用户 */
    @SelectProvider(type = SysUserProvider.class, method = "selectByParamsSql")
    @Results(id = "resultMap", value = {
            @Result(id=true,property="id",column="id"),
            @Result(property = "pid",column="pid"),
            @Result(property = "deptId",column="dept_id"),
            @Result(property = "deptName", column = "dept_name"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "lastLoginTime", column = "last_login_time"),
            @Result(property = "lastLoginIp", column = "last_login_ip"),
            @Result(property = "lastLoginAdd", column = "last_login_add"),
            @Result(property = "head", column = "head"),
            @Result(property = "isLook", column = "is_look"),
            @Result(property = "onJob", column = "on_job"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "updateUser", column = "update_user"),
    })
    List<SysUser> selectByParams(SysUser user);

    /** 重置用户密码 */
    @Update("UPDATE sys_user SET password = #{md5} WHERE id = #{id}")
    int restPwd(@Param("md5") String md5, @Param("id") Integer id);

    /** 根据用户名查找用户 */
    @Select("SELECT * FROM sys_user WHERE is_del = 0 AND username = #{username}")
    @ResultMap("resultMap")
    SysUser selectByUsername(@Param("username") String username);

    /** 根据用户id查找用户个数，判断数据库中是否有该用户 */
    @Select("SELECT COUNT(*) FROM sys_user WHERE is_del = 0 AND id = #{id}")
    int selectTotalById(@Param("id") Integer id);

    /** 根据用户id查找用户的角色 */
    @Select("SELECT r.code FROM sys_user u LEFT JOIN sys_user_role ur ON u.id = ur.user_id LEFT JOIN sys_role r ON ur.role_id = r.id WHERE u.id = #{id}")
    List<String> selectRoleByUserId(@Param("id") Integer id);

    /** 根据用户id查找用户权限 */
    @Select("SELECT m.permission FROM sys_user u LEFT JOIN sys_user_role ur ON u.id = ur.user_id LEFT JOIN sys_role r ON ur.role_id = r.id LEFT JOIN sys_role_menu rm ON r.id = rm.role_id LEFT JOIN sys_menu m ON rm.menu_id = m.id WHERE u.id = #{id}")
    List<String> selectPermissionByUserId(@Param("id") Integer id);

    /** 根据用户id查找用户所拥有的菜单 */
    @Select("SELECT m.* FROM sys_user u LEFT JOIN sys_user_role ur ON u.id = ur.user_id LEFT JOIN sys_role r ON ur.role_id = r.id LEFT JOIN sys_role_menu rm ON r.id = rm.role_id LEFT JOIN sys_menu m ON rm.menu_id = m.id WHERE m.type <> 1 AND m.is_del = 0 AND m.start = 1 AND u.id = #{id} ORDER BY m.sort")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "pid", column = "pid"),
            @Result(property = "type", column = "type"),
            @Result(property = "name", column = "name"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "url", column = "url"),
            @Result(property = "permission", column = "permission"),
            @Result(property = "sort", column = "sort"),
    })
    List<SysMenu> selectMenuById(@Param("id") Integer id);
}