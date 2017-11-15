package com.he.spring.he1.bean;

/**
 * Created by heyanjing on 2017/11/15 8:59.
 */
public class FactoryBean {

    private static FactoryBean bean = new FactoryBean();

    private FactoryBean() {
    }

    public FactoryBean instance() {
        return bean;
    }
}
