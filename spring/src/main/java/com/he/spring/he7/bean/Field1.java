package com.he.spring.he7.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
public class Field1 {
    private static final Logger log = LoggerFactory.getLogger(Field1.class);
    private String name;

    @PostConstruct
    public void init() {
        log.error("Field1---init");
    }

    @PreDestroy
    public void destory() {
        log.error("Field1---destory");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString()+"     Field1{" +
                "name='" + name + '\'' +
                '}';
    }
}
