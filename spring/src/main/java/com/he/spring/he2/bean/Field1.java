package com.he.spring.he2.bean;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
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
        return "Field1{" +
                "name='" + name + '\'' +
                '}';
    }
}
