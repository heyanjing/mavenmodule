package com.he.spring.bean;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by heyanjing on 2017/11/18 16:13.
 */
public class User1 implements java.io.Serializable {

    private Integer id;

    /*
     * 测试的时候，发现在页面获取到的数据传到User模式后，都是非空的。
     */
    @NotNull(message = "{user.name.null}")
    private String username;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private long salary;

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
