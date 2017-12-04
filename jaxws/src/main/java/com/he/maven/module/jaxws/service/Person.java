package com.he.maven.module.jaxws.service;

import java.util.Date;

/**
 * Created by heyanjing on 2017/12/4 16:46.
 */
public class Person {
    private String name;
    private Integer age;
    private Date birthday;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Person() {

    }

    public Person(String name, Integer age, Date birthday) {

        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}
