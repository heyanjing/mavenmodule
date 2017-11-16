package com.he.spring.web.controlleradvice;

/**
 * Created by heyanjing on 2017/11/16 13:57.
 */
public class AdviceBean {
    private String name;

    @Override
    public String toString() {
        return "AdviceBean{" +
                "name='" + name + '\'' +
                '}';
    }

    public AdviceBean() {
    }

    public AdviceBean(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
