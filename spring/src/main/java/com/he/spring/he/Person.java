package com.he.spring.he;

import java.time.LocalDateTime;

/**
 * Created by heyanjing on 2017/11/14 17:15.
 */
public class Person {
    private String name;
    private Integer age;
    private LocalDateTime birthday;

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

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Person() {

    }

    public Person(String name, Integer age, LocalDateTime birthday) {

        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}
