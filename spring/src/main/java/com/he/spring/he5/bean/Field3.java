package com.he.spring.he5.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
@Component
public class Field3 {
    private static final Logger log = LoggerFactory.getLogger(Field3.class);
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Field3{" +
                "name='" + name + '\'' +
                '}';
    }
}
