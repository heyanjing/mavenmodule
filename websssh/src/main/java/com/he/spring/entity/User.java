package com.he.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "user")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotEmpty(message = "名字不能为空")
    private String  name;
    @Range(min = 0, max = 120, message = "年龄必须在{min}到{max}之间")
    private Integer age;
    private Date    birthday;

    public User(String name, Integer age, Date birthday) {
        super();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Transient
    private String names;

    @Transient
    public String getNames() {
        return this.name + "窝草";
    }
}
