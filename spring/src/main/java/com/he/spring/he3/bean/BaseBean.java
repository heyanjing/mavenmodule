package com.he.spring.he3.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by heyanjing on 2017/11/15 8:58.
 */
public class BaseBean {
    private Field1 field1;
    private Field2 field2;
    private List<Object> list;
    private Set<Object> set;
    private Map<Object,Object> map;
    private Properties properties;

    @Override
    public String toString() {
        return "BaseBean{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
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

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Set<Object> getSet() {
        return set;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public BaseBean(Field1 field1, Field2 field2, List<Object> list, Set<Object> set, Map<Object, Object> map, Properties properties) {

        this.field1 = field1;
        this.field2 = field2;
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
    }

    public BaseBean() {

    }
}
