package com.ssyccjxy.service.system;

import java.util.List;

/**
 * Description：角色菜单Servie
 * Cteated by wangpeng
 * 2018/4/7 16:17
 */
public interface SysRoleMenuService {

    void updateRoleMenu(Integer roleId, List<Integer> menuIds);
}
