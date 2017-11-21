package com.he.spring.he11.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by heyanjing on 2017/11/21 14:41.
 */
@Entity(name="users")
public class Users {


    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid2" )   //指定生成器名称
    @GenericGenerator(name = "uuid2", strategy = "uuid2" )  //生成器名称，uuid生成类
    @Column(name="id")
    private String id;

    @Column(name="user_name",length=32)
    private String user_name;

    @Column(name="age")
    private Integer age;

    @Column(name="nice_name",length=32)
    private String nice_name;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getNice_name() {
        return nice_name;
    }
    public void setNice_name(String nice_name) {
        this.nice_name = nice_name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", age=" + age +
                ", nice_name='" + nice_name + '\'' +
                '}';
    }
}
