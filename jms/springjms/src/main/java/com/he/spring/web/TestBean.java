package com.he.spring.web;

import java.io.Serializable;

/**
 * Created by heyanjing on 2017/12/6 17:00.
 */
public class TestBean implements Serializable {
    private int age;
    private String name;

    public TestBean() {
    }


    public TestBean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}