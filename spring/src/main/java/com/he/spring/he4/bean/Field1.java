package com.he.spring.he4.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
public class Field1 {
    private static final Logger log = LoggerFactory.getLogger(Field1.class);
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        log.warn(super.toString());
        return "Field1{" +
                "name='" + name + '\'' +
                '}';
    }
}
