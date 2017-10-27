package com.he.maven.module.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by heyanjing on 2017/10/26 17:37.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration({"classpath*:spring/spring-base*.xml"}) //加载配置文件
@Transactional//控制事务,测试类中总会回滚，不会向数据库中写入数据
public class BaseTest {
}
