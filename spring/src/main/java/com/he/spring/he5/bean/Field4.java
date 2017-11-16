package com.he.spring.he5.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
public class Field4 implements BeanNameAware {
    private static final Logger log = LoggerFactory.getLogger(Field4.class);
    private String name;

    @PostConstruct
    public void init() {
        log.debug("Field4---init");
    }

    @PreDestroy
    public void destory() {
        log.debug("Field4---destory");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Field4{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String s) {
        log.debug("这个bean的id是:"+s);//这个bean的id是:field4     field4是在xml中配置的id
    }
}
