package com.ssyccjxy.service.system.impl;

import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.entity.system.SysRoleMenu;
import com.ssyccjxy.mapper.system.SysRoleMenuMapper;
import com.ssyccjxy.service.system.SysRoleMenuService;
import com.ssyccjxy.web.exception.CustomException;
import com.ssyccjxy.web.shiro.MyRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description 角色菜单ServiceImpl
 * Cteated by wangpeng
 * 2018/4/7 16:19
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private MyRealm myRealm;


    @Override
    @Transactional
    public void updateRoleMenu(Integer roleId, List<Integer> menuIds) {
        if (roleId == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "失败，roleId = null");
        }
        sysRoleMenuMapper.deleteRoleMenu(roleId);
        myRealm.clearCached();
        if (menuIds != null && menuIds.size()>0) {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(roleId);
            for (Integer menuId : menuIds) {
                roleMenu.setMenuId(menuId);
                int Result = sysRoleMenuMapper.insertRoleMenu(roleMenu);
                if (Result < 1) {
                    throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "失败，系统异常");
                }
            }
        }
        myRealm.clearCached();
    }
}
