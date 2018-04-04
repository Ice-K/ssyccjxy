package com.ssyccjxy.mapper.system;

import com.ssyccjxy.common.enums.IsDelEnum;
import com.ssyccjxy.entity.system.SysUser;
import org.apache.ibatis.jdbc.SQL;

/**
 * Description: SysUserSqlProvider
 * Cteated by wangpeng
 * 2018/3/30 23:50
 */
public class SysUserProvider {

    private static final String TABLE_NAME = "sys_user";
    private static final String COLUMNS = "id, pid, dept_id, dept_name, username, password, real_name, phone, last_login_time, last_login_ip, " +
            "last_login_add, head, is_look, on_job, is_del, create_time, create_user, update_time, update_user";

    /**
     * 添加
     * @param user  用户
     * @return sql
     */
    public String insertSql(final SysUser user) {
        return new SQL(){{
            INSERT_INTO(TABLE_NAME);
            VALUES("pid","#{pid}");
            VALUES("dept_id","#{deptId}");
            VALUES("dept_name","#{deptName}");
            VALUES("username","#{username}");
            VALUES("password","#{password}");
            VALUES("real_name","#{realName}");
            VALUES("phone","#{phone}");
            VALUES("last_login_time","#{lastLoginTime}");
            VALUES("last_login_ip","#{lastLoginIp}");
            VALUES("last_login_add","#{lastLoginAdd}");
            VALUES("head","#{head}");
            VALUES("is_look","#{isLook}");
            VALUES("on_job","#{onJob}");
            VALUES("is_del","#{isDel}");
            VALUES("create_time","now()");
            VALUES("create_user","#{createUser}");
            VALUES("update_time","now()");
            VALUES("update_user","#{updateUser}");
        }}.toString();
    }


    /**
     * 修改
     * @param user 用户
     * @return sql
     */
    public String updateByIdSql(final SysUser user) {
        return new SQL() {{
            UPDATE(TABLE_NAME);
            if (user.getPid() != null) { SET("pid = #{pid}"); }
            if (user.getDeptId() != null) { SET("dept_id = #{deptId}"); }
            if (user.getDeptName() != null) { SET("dept_name = #{deptName}"); }
            if (user.getUsername() != null) { SET("username = #{username}"); }
            if (user.getPassword() != null) { SET("password = #{password}"); }
            if (user.getRealName() != null) { SET("real_name = #{realName}"); }
            if (user.getPhone() != null) { SET("phone = #{phone}"); }
            if (user.getLastLoginTime() != null) { SET("last_login_time = #{lastLoginTime}"); }
            if (user.getLastLoginAdd() != null) { SET("last_login_add = #{lastLoginAdd}"); }
            if (user.getLastLoginIp() != null) { SET("last_login_ip = #{lastLoginIp}"); }
            if (user.getHead() != null) { SET("head = #{head}"); }
            if (user.getIsLook() != null) { SET("is_look = #{isLook}"); }
            if (user.getOnJob() != null) { SET("on_job = #{onJob}"); }
            if (user.getIsDel() != null) { SET("is_del = #{isDel}"); }
            if (user.getCreateTime() != null) { SET("create_time = #{createTime}"); }
            if (user.getCreateUser() != null) { SET("create_user = #{createUser}"); }
            if (user.getUpdateTime() != null) {
                SET("update_time = #{updateTime}");
            } else {
                SET("update_time = now()");
            }
            if (user.getUpdateUser() != null) { SET("update_user = #{updateUser}"); }
            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * 根据条件查询用户信息
     * @param user 查询参数封装
     * @return
     */
    public String selectByParamsSql(final SysUser user) {
        return new SQL(){{
            SELECT(COLUMNS);
            FROM(TABLE_NAME);
            WHERE("is_del = " + IsDelEnum.NO_DEL.getCode());
            if (user != null) {
                if (user.getUsername() != null) WHERE("username = #{username}");
                if (user.getPhone() != null) WHERE("phone = #{phone}");
                if (user.getRealName() != null) WHERE("real_name LIKE '%'#{realName}'%'");
                if (user.getDeptName() != null) WHERE("dept_name LIKE '%'#{deptName}'%'");
                if (user.getCreateTime() != null) WHERE("create_time >= createTime");
            }
        }}.toString();
    }

}
