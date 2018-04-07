package com.ssyccjxy.mapper.system;

import com.ssyccjxy.common.enums.IsDelEnum;
import com.ssyccjxy.entity.system.SysMenu;
import org.apache.ibatis.jdbc.SQL;

/**
 * Description：菜单Provider
 * Cteated by wangpeng
 * 2018/4/7 14:37
 */
public class SysMenuProvider {

    private static final String TABLE_NAME = "sys_menu";
    private static final String COLUMNS = "id, pid, type, name, icon, url, permission, sort, is_del, start, create_time, create_user, update_time, update_user";

    /** 添加 */
    public String insertSql(final SysMenu sysMenu) {
        return new SQL() {{
            INSERT_INTO(TABLE_NAME);
            VALUES("pid", "#{pid}");
            VALUES("type", "#{type}");
            VALUES("name", "#{name}");
            VALUES("icon", "#{icon}");
            VALUES("url", "#{url}");
            VALUES("permission", "#{permission}");
            VALUES("sort", "#{sort}");
            VALUES("is_del", "#{isDel}");
            VALUES("start", "#{start}");
            if (sysMenu.getCreateTime() != null) {
                VALUES("create_time", "#{createTime}");
            } else {
                VALUES("create_time", "date_format(now(), '%Y-%c-%d %h:%i:%s')");
            }
            VALUES("create_user", "#{createUser}");
            if (sysMenu.getUpdateTime() != null) {
                VALUES("update_time", "#{updateTime}");
            } else {
                VALUES("update_time", "date_format(now(), '%Y-%c-%d %h:%i:%s')");
            }
            VALUES("update_user", "#{updateUser}");
        }}.toString();
    }

    /** 修改 */
    public String updateSql(final SysMenu sysMenu) {
        return new SQL() {{
            UPDATE(TABLE_NAME);
            if (sysMenu.getPid() != null) SET("pid = #{pid}");
            if (sysMenu.getType() != null) SET("type = #{type}");
            if (sysMenu.getName() != null) SET("name = #{name}");
            if (sysMenu.getIcon() != null) SET("icon = #{icon}");
            if (sysMenu.getUrl() != null) SET("url = #{url}");
            if (sysMenu.getPermission() != null) SET("permission = #{permission}");
            if (sysMenu.getSort() != null) SET("sort = #{sort}");
            if (sysMenu.getIsDel() != null) SET("is_del = #{isDel}");
            if (sysMenu.getStart() != null) SET("start = #{start}");
            if (sysMenu.getUpdateTime() != null) {
                SET("update_time = #{updateTime}");
            } else {
                SET("update_time = date_format(now(), '%Y-%c-%d %h:%i:%s')");
            }
            if (sysMenu.getUpdateUser() != null) SET("update_user = #{updateUser}");
        }}.toString();
    }

    /** 根据条件查询 */
    public String selectSql(final SysMenu sysMenu) {
        return new SQL() {{
            SELECT(COLUMNS);
            FROM(TABLE_NAME);
            WHERE("is_del = " + IsDelEnum.NO_DEL.getCode());
            if (sysMenu != null) {
                if (sysMenu.getName() != null) WHERE("name LIKE \"%\"#{name}\"%\"");
            }
            ORDER_BY("sort");
        }}.toString();
    }


}
