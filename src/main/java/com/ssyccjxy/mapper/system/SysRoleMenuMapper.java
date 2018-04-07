package com.ssyccjxy.mapper.system;

import com.ssyccjxy.entity.system.SysRoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description：角色菜单Mapper
 * Cteated by wangpeng
 * 2018/4/7 15:45
 */
@Mapper
public interface SysRoleMenuMapper {

    @Insert("INSERT INTO sys_role_menu (role_id, menu_id) VALUES(#{roleId}, #{menuId})")
    int insertRoleMenu(SysRoleMenu sysRoleMenu);

    @Delete("DELETE FROM sys_role_menu WHERE role_id = #{roleId}")
    void deleteRoleMenu(@Param("roleId") Integer roleId);
}
