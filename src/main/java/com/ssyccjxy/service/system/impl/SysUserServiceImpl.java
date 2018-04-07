package com.ssyccjxy.service.system.impl;

import com.ssyccjxy.common.enums.ResultEnum;
import com.ssyccjxy.entity.system.SysMenu;
import com.ssyccjxy.entity.system.SysUser;
import com.ssyccjxy.mapper.system.SysUserMapper;
import com.ssyccjxy.service.system.SysUserService;
import com.ssyccjxy.web.exception.CustomException;
import com.ssyccjxy.web.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description：系统用户Service实现类
 * Cteated by wangpeng
 * 2018/3/31 11:25
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional
    public int addUser(SysUser user) {
        if (user == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(),"参数为空 user = null");
        }
        int result = sysUserMapper.insert(user);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(),"添加失败，服务器异常");
        }
        return result;
    }

    @Override
    @Transactional
    public int delUser(String ids) {
        if (!StringUtil.isNotBlank(ids)) {
            throw new CustomException(ResultEnum.ERROR.getCode(),"参数为空 ids = null");
        }
        int result = sysUserMapper.deleteByIds(ids);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "删除失败，服务器异常");
        }
        return result;
    }

    @Override
    @Transactional
    public int delSupUser(String ids) {
        if (!StringUtil.isNotBlank(ids)) {
            throw new CustomException(ResultEnum.ERROR.getCode(),"参数为空 ids = null");
        }
        int result = sysUserMapper.deleteSupByIds(ids);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "删除失败，服务器异常");
        }
        return result;
    }

    @Override
    @Transactional
    public int updateUser(SysUser user) {
        if (user == null || user.getId() == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(),"参数 user = null 或者 id = null");
        }
        int result = sysUserMapper.updateById(user);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(),"修改失败，服务器异常");
        }

        return result;
    }

    @Override
    @Transactional
    public int restPwd(String md5, Integer id) {
        if (!StringUtil.isNotBlank(md5)) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "参数 md5 为空");
        }
        if (id == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "参数 id = null");
        }
        int total = sysUserMapper.selectTotalById(id);
        if (total < 1) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "没有该用户 id = " + id);
        }
        int result = sysUserMapper.restPwd(md5, id);
        if (result < 1) {
            throw new CustomException(ResultEnum.SYS_SERVER_ERROR.getCode(), "修改失败,系统异常");
        }
        return result;
    }

    @Override
    public SysUser selectByUsername(String username) {
        if (!StringUtil.isNotBlank(username)) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "请输入用户名");
        }
        return sysUserMapper.selectByUsername(username);
    }

    @Override
    public SysUser selectById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "查询失败 id = null");
        }
        return  sysUserMapper.selectById(id);
    }

    @Override
    public List<SysUser> selectByParams(SysUser user) {
        return sysUserMapper.selectByParams(user);
    }


    @Override
    public Set<String> selectRoleById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "失败，id = null");
        }
        List<String> list = sysUserMapper.selectRoleByUserId(id);
        return new HashSet<>(list);
    }

    @Override
    public Set<String> selectPermissionById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "失败，id = null");
        }
        List<String> list = sysUserMapper.selectPermissionByUserId(id);
        return new HashSet<>(list);
    }

    @Override
    public List<SysMenu> selectMenuById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "失败，id = null");
        }
        List<SysMenu> list = sysUserMapper.selectMenuById(id);
        List<SysMenu> newList = new ArrayList<>();
        Set<SysMenu> set = new HashSet<>();
        for (SysMenu menu : list) {
            if (set.add(menu)) {
                newList.add(menu);
            }
        }
        list.clear();
        list.addAll(newList);
        return list;
    }
}
