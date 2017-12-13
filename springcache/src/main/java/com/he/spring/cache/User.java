package com.he.spring.cache;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by heyanjing on 2017/12/13 14:11.
 */
public class User implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private LocalDate birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public User(String id, String name, Integer age, LocalDate birthday) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
