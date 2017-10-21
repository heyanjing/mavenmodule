package com.he.spring.entity;

import com.he.spring.entity.base.BaseEntityWithStringId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "person")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
public class Person extends BaseEntityWithStringId {

    @NotEmpty(message = "名字不能为空")
    private String  name;
    @Range(min = 0, max = 120, message = "年龄必须在{min}到{max}之间")
    private Integer age;
    private Integer state;
    private Date    birthday;

    public Person(String name, Integer age, Date birthday,Integer state) {
        super();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.state=state;
    }

    @Transient
    private String names;

    @Transient
    public String getNames() {
        return names==null?this.name + "窝草":names;
    }
}
