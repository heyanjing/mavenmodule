package com.he.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/12/7 14:59.
 */
public class MyBeanMessageListener {
    private static final Logger log = LoggerFactory.getLogger(MyBeanMessageListener.class);

    public void handleMessage(String message) {
        log.warn("MyBeanMessageListener，消息内容是：" + message);
    }

    public Object receiveMessage(TestBean bean) {
        log.warn("MyBeanMessageListener，消息内容是：" + bean);

        return "MyBeanMessageListener，消息内容是：" + bean;
    }
}
