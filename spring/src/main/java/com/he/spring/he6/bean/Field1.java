package com.he.spring.he6.bean;

import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
@Component
public class Field1 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString()+"    Field1{" +
                "name='" + name + '\'' +
                '}';
    }
}
