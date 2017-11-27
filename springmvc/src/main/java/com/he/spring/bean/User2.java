package com.he.spring.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by heyanjing on 2017/11/23 16:16.
 */
public class User2 {
    private  String namex;
    private  Integer agex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdayx;

    public User2() {
    }

    public User2(String namex, Integer agex, Date birthdayx) {
        this.namex = namex;
        this.agex = agex;
        this.birthdayx = birthdayx;
    }

    public String getNamex() {

        return namex;
    }

    public void setNamex(String namex) {
        this.namex = namex;
    }

    public Integer getAgex() {
        return agex;
    }

    public void setAgex(Integer agex) {
        this.agex = agex;
    }

    public Date getBirthdayx() {
        return birthdayx;
    }

    public void setBirthdayx(Date birthdayx) {
        this.birthdayx = birthdayx;
    }

    @Override
    public String toString() {
        return "User2{" +
                "namex='" + namex + '\'' +
                ", agex=" + agex +
                ", birthdayx=" + birthdayx +
                '}';
    }
}
