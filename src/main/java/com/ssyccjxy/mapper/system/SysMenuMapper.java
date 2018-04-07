package com.ssyccjxy.mapper.system;

import com.ssyccjxy.entity.system.SysMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Description：菜单Mapper
 * Cteated by wangpeng
 * 2018/4/7 14:22
 */
@Mapper
public interface SysMenuMapper {

    /** 添加 */
    @InsertProvider(type = SysMenuProvider.class, method = "insertSql")
    int insertMenu(SysMenu sysMenu);

    /** 修改 */
    @UpdateProvider(type = SysMenuProvider.class, method = "updateSql")
    int updateById(SysMenu sysMenu);

    /** 删除/批量删除，逻辑删除 */
    @Update("UPDATE sys_menu SET is_del = 1 WHERE id IN (${ids})")
    int deleteById(@Param("ids") List<Integer> ids);

    /** 删除/批量删除，物理删除 */
    @Delete("DELETE FROM sys_menu WHERE id IN (${ids})")
    int deleteSupById(@Param("ids") List<Integer> ids);

    /** 根据id查找菜单 */
    @Select("SELECT * FROM sys_menu WHERE is_del = 0 AND id = #{id}")
    @Results(id = "resultMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "pid", column = "pid"),
            @Result(property = "type", column = "type"),
            @Result(property = "name", column = "name"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "url", column = "url"),
            @Result(property = "permission", column = "permission"),
            @Result(property = "sort", column = "sort"),
            @Result(property = "isDel", column = "is_del"),
            @Result(property = "start", column = "start"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "updateUser", column = "update_user"),
    })
    SysMenu selectById(@Param("id") Integer id);

    /** 根据条件查询菜单 */
    @SelectProvider(type = SysMenuProvider.class, method = "selectSql")
    @ResultMap("resultMap")
    List<SysMenu> selectByParams(SysMenu sysMenu);

    /** 根据id查询菜单的个数， 用来判断菜单是否存在 */
    @Select("SELECT COUNT(*) FROM sys_menu WHERE is_del = 0 AND id = #{id}")
    int selectTotalById(@Param("id") Integer id);
}
