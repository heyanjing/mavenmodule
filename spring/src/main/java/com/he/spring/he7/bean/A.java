package com.he.spring.he7.bean;

/**
 * Created by heyanjing on 2017/11/16 16:59.
 */
public class A {
    private String name;

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A() {

    }

    public A(String name) {

        this.name = name;
    }
}
