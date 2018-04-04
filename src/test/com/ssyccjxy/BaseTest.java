package com.ssyccjxy;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Description：基本测试类 所有测试类继承此类
 * Cteated by wangpeng
 * 2018/3/31 17:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-spring.xml","classpath:applicationContext-mybatis.xml"})
@Rollback(value = true)
@Transactional(transactionManager = "transactionManager")
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
