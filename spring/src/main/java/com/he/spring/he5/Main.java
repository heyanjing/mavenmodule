package com.he.spring.he5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heyanjing on 2017/11/14 17:18.
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws InterruptedException {


        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"/he5/spring.xml"});
        ctx.registerShutdownHook();
        Thread.sleep(20000);

        //region Description
        //        Field1 field1 = ctx.getBean("field1", Field1.class);
//        log.info("{}",field1);
//
//        Field2 field2 = ctx.getBean("field2", Field2.class);
//        log.warn("{}",field2);
//
//        Field3 field3 = ctx.getBean(Field3.class);
//        log.error("{}",field3);
//
//
//
//        Thread.sleep(10000);
//
//        Field1 field1x = ctx.getBean("field1", Field1.class);
//        log.info("{}",field1x);
//
//        Field2 field2x = ctx.getBean("field2", Field2.class);
//        log.warn("{}",field2x);
        //endregion
        ctx.stop();
    }
}
