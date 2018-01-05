package com.he.spring.bean;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by heyanjing on 2017/11/18 16:13.
 */
public class User implements java.io.Serializable {

    private Integer id;

    /**
     * 测试的时候，发现在页面获取到的数据传到User模式后，都是非空的。
     */
    @NotNull(message = "${user.name.null}")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(min = 2, max = 6, message = "长度是2-6之间")
    private String password;

    @NotNull(message = "时间不能为空")
    @Past(message = "必须是一个过去的时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")// MEINFO:2017/11/18 18:00 用于将请求参数封装成bean时使用
    private Date birthday;

    @DecimalMin(value = "1000.00", message = "工资必须大于1000.00")
    @DecimalMax(value = "10000.00", message = "工资必须小于10000.00")
    @NumberFormat(pattern = "#,###.##")
    private long salary;

    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = "1[3|4|5|8][0-9]\\d{4,8}", message = "手机号码不匹配")
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
