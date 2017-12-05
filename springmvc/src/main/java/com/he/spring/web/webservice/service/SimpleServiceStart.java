package com.he.spring.web.webservice.service;

import org.apache.cxf.frontend.ServerFactoryBean;

/**
 * Created by heyanjing on 2017/12/5 10:19.
 */
public class SimpleServiceStart {

    public static void main(String[] args) {
        SimpleServiceImpl simpleService = new SimpleServiceImpl();
        ServerFactoryBean factoryBean = new ServerFactoryBean();
        factoryBean.setServiceBean(ISimpleService.class);
        factoryBean.setAddress("http://localhost:8080/ws/simple");
        factoryBean.setServiceBean(new SimpleServiceImpl());
        factoryBean.create();
    }
}
