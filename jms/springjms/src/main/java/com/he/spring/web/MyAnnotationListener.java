package com.he.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/12/8 11:22.
 */
@Component
public class MyAnnotationListener {
    private static final Logger log = LoggerFactory.getLogger(MyAnnotationListener.class);

//    @JmsListener(destination="",concurrency="5-10")
    @JmsListener(destination = "spring-queue")
    public Object receiveMessage(Object bean) {
        log.warn("MyAnnotationListener，消息内容是：" + bean);
        return "MyAnnotationListener，消息内容是：" + bean;
    }
}
