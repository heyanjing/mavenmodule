package com.he.spring.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by heyanjing on 2017/12/11 11:17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
public class ScheduleTaskTest {
    private static final Logger log = LoggerFactory.getLogger(ScheduleTaskTest.class);

    @Test
    public void test() {
        while (true){

        }
    }
    @Test
    public void testEx() {
    }


}