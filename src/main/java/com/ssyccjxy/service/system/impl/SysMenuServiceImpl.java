package com.ssyccjxy.service.system.impl;

import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.entity.system.SysMenu;
import com.ssyccjxy.mapper.system.SysMenuMapper;
import com.ssyccjxy.service.system.SysMenuService;
import com.ssyccjxy.web.exception.CustomException;
import com.ssyccjxy.web.shiro.MyRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：菜单serviceImpl
 * Cteated by wangpeng
 * 2018/4/7 15:28
 */
@Service
public class SysMenuServiceImpl implements SysMenuService{

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private MyRealm myRealm;

    @Override
    public int addMenu(SysMenu sysMenu) {
        if (sysMenu == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "sysMenu = null");
        }
        int result = sysMenuMapper.insertMenu(sysMenu);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "系统异常");
        }
        return result;
    }

    @Override
    public int deleteMenu(List<Integer> ids) {
        if (ids == null || ids.size()<1) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "参数ids = null");
        }
        int result = sysMenuMapper.deleteById(ids);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "删除失败，系统异常");
        }
        myRealm.clearCached();
        return result;
    }

    @Override
    public int deleteSupMenu(List<Integer> ids) {
        if (ids == null || ids.size()<1) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "参数ids = null or size < 1");
        }
        int result = sysMenuMapper.deleteSupById(ids);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "删除失败，系统异常");
        }
        myRealm.clearCached();
        return result;
    }

    @Override
    public int updateMenu(SysMenu sysMenu) {
        if (sysMenu == null || sysMenu.getId() == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "修改失败, sysMenu = null or id = null");
        }
        int result = sysMenuMapper.updateById(sysMenu);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "修改失败，系统异常");
        }
        myRealm.clearCached();
        return result;
    }

    @Override
    public SysMenu selectOne(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "id = null");
        }
        SysMenu sysMenu = sysMenuMapper.selectById(id);
        if (sysMenu == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "系统异常");
        }
        return sysMenu;
    }

    @Override
    public List<SysMenu> selectList(SysMenu sysMenu) {
        return sysMenuMapper.selectByParams(sysMenu);
    }
}
