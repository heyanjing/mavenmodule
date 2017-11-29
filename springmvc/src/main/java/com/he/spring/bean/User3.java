package com.he.spring.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by heyanjing on 2017/11/23 16:16.
 */
public class User3 {
    @JsonView(value ={com.he.spring.json.JsonView.Name.class} )
    private  String name;
    @JsonView(value ={com.he.spring.json.JsonView.NameAndAge.class} )
    private  Integer age;
    @JsonView(value ={com.he.spring.json.JsonView.NameAndAgeAndBirthday.class} )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthday;


    @JsonFormat(pattern ="yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate date;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime dateTime;

    public User3(String name, Integer age, Date birthday, LocalDate date, LocalDateTime dateTime) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.date = date;
        this.dateTime = dateTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User3() {
    }

    public User3(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
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
}
