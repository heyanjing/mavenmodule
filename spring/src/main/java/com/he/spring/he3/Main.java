package com.he.spring.he3;

import com.he.spring.he3.bean.BaseBean;
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


        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"/he3/spring.xml"});
        BaseBean baseBean = ctx.getBean("baseBean", BaseBean.class);
        log.info("{}",baseBean);

    }
}
