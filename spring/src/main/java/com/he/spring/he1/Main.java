package com.he.spring.he1;

import com.he.spring.he1.bean.BaseBean;
import com.he.spring.he1.bean.FactoryBean;
import com.he.spring.he1.bean.StaticFactoryBean;
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"/he1/spring.xml"});
        BaseBean baseBean = ctx.getBean("baseBean", BaseBean.class);
        log.info("{}",baseBean);
        StaticFactoryBean staticFactoryBean = ctx.getBean("staticFactoryBean", StaticFactoryBean.class);
        log.info("{}",staticFactoryBean);
        FactoryBean factoryBeanInstance = ctx.getBean("factoryBeanInstance", FactoryBean.class);
        log.info("{}",factoryBeanInstance);


    }
}
