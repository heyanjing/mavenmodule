package com.he.spring.he7.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/11/15 9:17.
 */
public class Field2 {
    private static final Logger log = LoggerFactory.getLogger(Field2.class);
    private String name;
    private Field1 field1;
    public void init() {
        log.error("Field2---init");
    }

    public void destory() {
        log.error("Field2---destory");
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
        return "Field2{" +
                "name='" + name + '\'' +
                ", field1=" + field1 +
                '}';
    }
}
