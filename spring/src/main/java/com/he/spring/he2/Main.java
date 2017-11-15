package com.he.spring.he2;

import com.he.spring.he2.bean.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heyanjing on 2017/11/14 17:18.
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"/he2/spring.xml"});
        BaseBean baseBean1 = ctx.getBean("baseBean1", BaseBean.class);
        log.info("{}",baseBean1);
        BaseBean baseBean5 = ctx.getBean("baseBean5", BaseBean.class);
        log.info("{}",baseBean5);
        BaseBean baseBean2 = ctx.getBean("baseBean2", BaseBean.class);
        log.info("{}",baseBean2);
        BaseBean baseBean3 = ctx.getBean("baseBean3", BaseBean.class);
        log.info("{}",baseBean3);
        BaseBean baseBean4 = ctx.getBean("baseBean4", BaseBean.class);
        log.info("{}",baseBean4);
    }
}
