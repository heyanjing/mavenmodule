package com.he.spring.he7;

import com.he.spring.he7.annotationbean.Bean1;
import com.he.spring.he7.bean.A;
import com.he.spring.he7.bean.B;
import com.he.spring.he7.bean.C;
import com.he.spring.he7.bean.Field1;
import com.he.spring.he7.bean.Field2;
import com.he.spring.he7.bean.Field3;
import com.he.spring.he7.bean.Field4;
import com.he.spring.he7.bean.Field5;
import com.he.spring.he7.conf.AConf;
import com.he.spring.he7.conf.OtherConf;
import com.he.spring.he7.conf.RootConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by heyanjing on 2017/11/14 17:18.
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {


        //region Description 方式一
        ApplicationContext ctx1 = new AnnotationConfigApplicationContext(RootConf.class);
        Field1 field1 = ctx1.getBean(Field1.class);
        log.info("{}", field1);
        Field2 field2 = ctx1.getBean(Field2.class);
        log.info("{}", field2);
//        Field2 field2x = ctx1.getBean("field2x",Field2.class);//No bean named 'field2x' available
//        log.info("{}", field2x);
        Field4 field4 = ctx1.getBean(Field4.class);
        log.info("{}", field4);
        Bean1 bean1 = ctx1.getBean(Bean1.class);
        log.info("{}", bean1);
        Field3 field3 = ctx1.getBean(Field3.class);
        log.info("{}", field3);

        ApplicationContext ctx1x = new AnnotationConfigApplicationContext(OtherConf.class);
        Field5 field5 = ctx1x.getBean(Field5.class);
        log.info("{}", field5);


        ApplicationContext ctx1xx = new AnnotationConfigApplicationContext(AConf.class);
        C c = ctx1xx.getBean(C.class);
        log.info("{}", c);
        B b= ctx1xx.getBean(B.class);
        log.info("{}", b);
       A a = ctx1xx.getBean(A.class);
        log.info("{}", a);

//        ApplicationContext abc = new AnnotationConfigApplicationContext(ABCConf.class);
//        A a = abc.getBean(A.class);
//        log.info("{}", a);
//        B b = abc.getBean(B.class);
//        log.info("{}", b);
//        C c = abc.getBean(C.class);
//        log.info("{}", c);

        //endregion
        //region Description 方式二
//        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
//        ctx2.register(RootConf.class);
//        ctx2.scan("com.he.spring.annotation");
//        ctx2.refresh();
//
//        Field1 field1x = ctx2.getBean(Field1.class);
//        log.warn("{}", field1x);
//        Field2 field2x = ctx2.getBean(Field2.class);
//        log.warn("{}", field2x);
//        Bean1 bean1x = ctx2.getBean(Bean1.class);
//        log.warn("{}", bean1x);
        //endregion


    }
}
