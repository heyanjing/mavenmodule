package com.he.spring.he2.bean;

import java.beans.ConstructorProperties;

/**
 * Created by heyanjing on 2017/11/15 8:58.
 */
public class BaseBean {
    private Field1 field1;
    private Field2 field2;
    private String str1;
    private String str2;
    private int int1;
    private int int2;

    public BaseBean() {
    }

    @ConstructorProperties({"field1","field2","str1","str2","int1","int2"})
    public BaseBean(Field1 field1, Field2 field2, String str1, String str2, int int1, int int2) {
        this.field1 = field1;
        this.field2 = field2;
        this.str1 = str1;
        this.str2 = str2;
        this.int1 = int1;
        this.int2 = int2;
    }

    public Field1 getField1() {
        return field1;
    }

    public void setField1(Field1 field1) {
        this.field1 = field1;
    }

    public Field2 getField2() {
        return field2;
    }

    public void setField2(Field2 field2) {
        this.field2 = field2;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                ", str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", int1=" + int1 +
                ", int2=" + int2 +
                '}';
    }
}
