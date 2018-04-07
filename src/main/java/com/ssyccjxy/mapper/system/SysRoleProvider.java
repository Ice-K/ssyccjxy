package com.ssyccjxy.mapper.system;

import com.ssyccjxy.common.enums.IsDelEnum;
import com.ssyccjxy.entity.system.SysRole;
import org.apache.ibatis.jdbc.SQL;

/**
 * Description：角色Provider
 * Cteated by wangpeng
 * 2018/4/7 11:06
 */
public class SysRoleProvider {

    private static final String TABLE_NAME = "sys_role";
    private static final String COLUMNS = "id, name, code, description, is_del, start, create_time, create_user, update_time, update_user";


    /** 添加 */
    public String insertSql(final SysRole sysRole) {
        return new SQL(){{
            INSERT_INTO(TABLE_NAME);
            VALUES("name", "#{name}");
            VALUES("code", "#{code}");
            VALUES("description", "#{description}");
            VALUES("is_del", "#{isDel}");
            VALUES("start", "#{start}");
            if (sysRole.getCreateTime() == null) {
                VALUES("create_time", "date_format(now(), '%Y-%c-%d %h:%i:%s')");
            } else {
                VALUES("create_time", "#{createTime}");
            }
            VALUES("create_user", "#{createUser}");
            if (sysRole.getUpdateTime() == null) {
                VALUES("update_time", "date_format(now(), '%Y-%c-%d %h:%i:%s')");
            } else {
                VALUES("update_time", "#{updateTime}");
            }
            VALUES("update_user", "#{updateUser}");
        }}.toString();
    }

    /** 修改. */
    public String updateSql(final SysRole sysRole) {
        return new SQL() {{
            UPDATE(TABLE_NAME);
            if (sysRole.getCode() != null) SET("code= #{code}");
            if (sysRole.getDescription() != null) SET("description = #{description}");
            if (sysRole.getIsDel() != null) SET("is_del = #{isDel}");
            if (sysRole.getStart() != null) SET("start = #{start}");
            if (sysRole.getCreateTime() != null) SET("create_time = #{createTime}");
            if (sysRole.getCreateUser() != null) SET("create_user = #{createUser}");
            if (sysRole.getUpdateTime() != null) {
                SET("update_time = #{update_time}");
            } else {
                SET("update_time = date_format(now(), '%Y-%c-%d %h:%i:%s')");
            }
            if (sysRole.getCreateUser() != null) SET("update_user = #{updateUser}");
            WHERE("id = #{id}");
        }}.toString();
    }

    /** 根据条件查询角色信息 */
    public String selectSql(final SysRole sysRole) {
        return new SQL() {{
            SELECT(COLUMNS);
            FROM(TABLE_NAME);
            WHERE("is_del = " + IsDelEnum.NO_DEL.getCode());
            if (sysRole.getName() != null) WHERE("name = #{name}");
            if (sysRole.getCreateTime() != null) WHERE("create_time >= #{createTime}");
            ORDER_BY("update_time DESC");
        }}.toString();
    }

}
