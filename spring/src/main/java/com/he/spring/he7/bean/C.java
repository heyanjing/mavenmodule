package com.he.spring.he7.bean;

/**
 * Created by heyanjing on 2017/11/16 17:00.
 */
public class C {
    private String name;
    private B b;

    @Override
    public String toString() {
        return "C{" +
                "name='" + name + '\'' +
                ", b=" + b +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C() {

    }

    public C(String name, B b) {

        this.name = name;
        this.b = b;
    }
}