package com.he.spring.he7.annotationbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
@Component
public class Bean1 {
    private static final Logger log = LoggerFactory.getLogger(Bean1.class);
    private String name;


    @PostConstruct
    public void init() {
        log.error("Bean1---init");
    }

    @PreDestroy
    public void destory() {
        log.error("Bean1---destory");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "name='" + name + '\'' +
                '}';
    }
}
