package com.he.spring.he7.bean;

import com.he.spring.he7.annotationbean.Bean1;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
public class Field5 {
    private String name;
    private Field1 field1;
    private Bean1 bean1;

    public Field5(Bean1 bean1) {
        this.bean1 = bean1;
    }

    public Field5(Field1 field1, Bean1 bean1) {
        this.field1 = field1;
        this.bean1 = bean1;
    }

    @Override
    public String toString() {
        return "Field5{" +
                "name='" + name + '\'' +
                ", field1=" + field1 +
                ", bean1=" + bean1 +
                '}';
    }

    public Bean1 getBean1() {
        return bean1;
    }

    public void setBean1(Bean1 bean1) {
        this.bean1 = bean1;
    }

    public Field5() {
    }

    public Field5(Field1 field1) {

        this.field1 = field1;
    }

    public Field1 getField1() {
        return field1;
    }

    public void setField1(Field1 field1) {
        this.field1 = field1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
