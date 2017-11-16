package com.he.spring.he6.bean;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
public class Field3 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString()+"    Field3{" +
                "name='" + name + '\'' +
                '}';
    }
}
