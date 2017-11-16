package com.he.spring.he6.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by heyanjing on 2017/11/16 11:29.
 */
@Component
public class Bean {
    private static final Logger log = LoggerFactory.getLogger(Bean.class);
    @Autowired
    Field1 field1;
    @Autowired
    Field1 field1x;
    @Autowired(required = false)
    Field3 field3x;
    @Autowired
    A1 a1x;
    @Autowired
    A2 a2x;
//    @Autowired
//    A a3;//No qualifying bean of type 'com.he.spring.he6.bean.A' available: expected single matching bean but found 2: a1,a2
    @Autowired
    @Qualifier("a2")
    A ax;


    @PostConstruct
    public void init() {
        log.info("{}", field1);//com.he.spring.he6.bean.Field1@31aa3ca5    Field1{name='null'}
        log.info("{}", field1x);//com.he.spring.he6.bean.Field1@31aa3ca5    Field1{name='null'}
        log.info("{}", a1x);
        log.info("{}", a2x);//com.he.spring.he6.bean.A2@39ad977d
//        log.info("{}", a3);
        log.info("{}", ax);//com.he.spring.he6.bean.A2@39ad977d
        log.info("{}", field3x);
    }
}
