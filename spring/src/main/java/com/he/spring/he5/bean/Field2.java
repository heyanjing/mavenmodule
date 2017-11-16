package com.he.spring.he5.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
public class Field2 {
    private static final Logger log = LoggerFactory.getLogger(Field2.class);
    private String name;


    @PostConstruct
    public void init(){
        log.warn("Field2---init");
    }
    @PreDestroy
    public void destory(){
        log.warn("Field2---destory");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Field2{" +
                "name='" + name + '\'' +
                '}';
    }
}
