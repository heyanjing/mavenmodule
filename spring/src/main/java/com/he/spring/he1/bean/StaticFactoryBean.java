package com.he.spring.he1.bean;

/**
 * Created by heyanjing on 2017/11/15 8:59.
 */
public class StaticFactoryBean {

    private static StaticFactoryBean bean = new StaticFactoryBean();

    private StaticFactoryBean() {
    }

    public static StaticFactoryBean instance() {
        return bean;
    }
}
