package com.he.spring.web;

/**
 * Created by heyanjing on 2017/12/7 14:35.
 */
public class User {

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public User() {
    }

    public User(String name, int age, boolean sex) {

        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    private int age;
    private boolean sex;
}
