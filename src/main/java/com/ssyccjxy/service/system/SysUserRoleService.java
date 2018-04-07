package com.ssyccjxy.service.system;

import java.util.List;

/**
 * Description：用户角色Service
 * Cteated by wangpeng
 * 2018/4/7 15:54
 */
public interface SysUserRoleService {

    /** 修改 */
    void updateUserRole(Integer userId, List<Integer> roleIds);

}
