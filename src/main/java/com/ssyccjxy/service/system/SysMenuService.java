package com.ssyccjxy.service.system;

import com.ssyccjxy.entity.system.SysMenu;

import java.util.List;

/**
 * Description：菜单Service
 * Cteated by wangpeng
 * 2018/4/7 15:12
 */
public interface SysMenuService {

    int addMenu(SysMenu sysMenu);

    int deleteMenu(String ids);

    int deleteSupMenu(String ids);

    int updateMenu(SysMenu sysMenu);

    SysMenu selectOne(Integer id);

    List<SysMenu> selectList(SysMenu sysMenu);

}
