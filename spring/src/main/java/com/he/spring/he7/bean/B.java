package com.he.spring.he7.bean;

/**
 * Created by heyanjing on 2017/11/16 17:00.
 */
public class B {
    private String name;
    private A a;

    public B() {
    }

    public B(String name, A a) {

        this.name = name;
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", a=" + a +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
