package com.ssyccjxy.mapper.system;

import com.ssyccjxy.BaseTest;
import com.ssyccjxy.common.enums.HeadEnum;
import com.ssyccjxy.common.enums.IsLookEnum;
import com.ssyccjxy.entity.system.SysUser;
import com.ssyccjxy.web.util.MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Cteated by wangpeng
 * 2018/3/31 17:13
 */
public class SysUserMapperTest extends BaseTest{

    private static final Logger LOG = LogManager.getLogger(SysUserMapperTest.class);

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void deleteByIds() {
        int result = sysUserMapper.deleteByIds("1");
        logger.error(result);
    }

    @Test
    public void deleteSupByIds() {
    }

    @Test
    public void insert() {
        SysUser user = new SysUser();
        user.setPid(null);
        user.setDeptId(1);
        user.setDeptName("山西运城财经学院");
        user.setUsername("admin");
        user.setRealName("超级管理员");
        user.setPassword(MD5Util.generate("admin"));
        user.setHead(HeadEnum.ON_HEAD.getCode());
        user.setIsLook(IsLookEnum.NO_LOOK.getCode());
        user.setLastLoginAdd("本地");
        user.setPhone("18135453860");
        int result = sysUserMapper.insert(user);
        Assert.assertEquals(1,result);
        LOG.info("添加成功");
    }

    @Test
    public void selectById() {
    }

    @Test
    public void updateById() {
    }

    @Test
    public void selectByParams() {
        SysUser sysUser = new SysUser();
        sysUser.setRealName("超级");
        List<SysUser> list = sysUserMapper.selectByParams(sysUser);
        logger.info(list.size());
    }

    @Test
    public void restPwd() {
    }
}