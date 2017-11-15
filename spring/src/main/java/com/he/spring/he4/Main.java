package com.he.spring.he4;

import com.he.spring.he4.bean.BaseBean;
import com.he.spring.he4.bean.Field1;
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


        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"/he4/spring.xml"});
        BaseBean baseBean1 = ctx.getBean("baseBean", BaseBean.class);
        log.info("{}", baseBean1);
        BaseBean baseBean2 = Springs.getBean("baseBean", BaseBean.class);
        log.info("{}", baseBean2);

        Field1 field11 = ctx.getBean("field1", Field1.class);
        log.info("{}", field11);
        Field1 field12 = Springs.getBean("field1", Field1.class);
        log.info("{}", field12);


    }
}
