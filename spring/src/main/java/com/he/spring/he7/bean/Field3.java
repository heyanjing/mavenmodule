package com.he.spring.he7.bean;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
public class Field3 {
    private String name;
    private Field1 field1;

    public Field3() {
    }

    public Field3(Field1 field1) {

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

    @Override
    public String toString() {
        return "Field3{" +
                "name='" + name + '\'' +
                ", field1=" + field1 +
                '}';
    }
}
