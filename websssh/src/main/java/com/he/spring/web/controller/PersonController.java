package com.he.spring.web.controller;

import com.he.maven.module.utils.Dates;
import com.he.maven.module.utils.Randoms;
import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import com.he.spring.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    private Integer count = 1;


    @RequestMapping("/test")
    @ResponseBody
    public Object test() {
        return this.personService.test();
    }

    /*
     * data
     * */
    @RequestMapping("/save")
    @ResponseBody
    public Person save() {
        Person p = new Person("name" + Dates.newDateString("yyyy-MM-dd_HH:mm:ss.SSS"), count++, Dates.newDate(), Randoms.getInt(5));
        return this.personService.save(p);
    }

    @RequestMapping("/getByIdSql")
    @ResponseBody
    public Person getByIdSql(String id) {
        return this.personService.getByIdSql(id);
    }


    @RequestMapping("/findAll")
    @ResponseBody
    public List<Person> findAll() {
        return this.personService.findAll();
    }

    /*
    * T
    * */
    @RequestMapping("/findAllxSql")
    @ResponseBody
    public List<Person> findAllxSql(Integer age) {
        return this.personService.findAllxSql(age);
    }

    @RequestMapping("/pageByNamexSql")
    @ResponseBody
    public Page<Person> findAllxSql(String name, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        return this.personService.pageByNamexSql(name, pageNumber, pageSize);
    }

    @RequestMapping("/findAllxHql")
    @ResponseBody
    public List<Person> findAllxHql(Integer age) {
        return this.personService.findAllxHql(age);
    }
    @RequestMapping("/findAllxHqlName")
    @ResponseBody
    public List<Person> findAllxHqlName(String name) {
        return this.personService.findAllxHqlName(name);
    }

    @RequestMapping("/pageByNamexHql")
    @ResponseBody
    public Page<Person> pageByNamexHql(String name, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        return this.personService.pageByNamexHql(name, pageNumber, pageSize);
    }
    /*
    * Custom
    * */

    @RequestMapping("/findAllxSqlCustom")
    @ResponseBody
    public List<Dog> findAllxSqlCustom(Integer age) {
        return this.personService.findAllxSqlCustom(age);
    }

    @RequestMapping("/pageByNamexSqlCustom")
    @ResponseBody
    public Page<Dog> pageByNamexSqlCustom(String name, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        return this.personService.pageByNamexSqlCustom(name, pageNumber, pageSize);
    }

    @RequestMapping("/findAllxHqlCustom")
    @ResponseBody
    public List<Dog> findAllxHqlCustom(Integer age) {
        return this.personService.findAllxHqlCustom(age);
    }

    @RequestMapping("/pageByNamexHqlCustom")
    @ResponseBody
    public Page<Dog> pageByNamexHqlCustom(String name, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        return this.personService.pageByNamexHqlCustom(name, pageNumber, pageSize);
    }

    /*
    * map
    * */
    @RequestMapping("/findAllxSqlCustomMap")
    @ResponseBody
    public List<Map<String, Object>> findAllxSqlCustomMap(Integer age) {
        return this.personService.findAllxSqlCustomMap(age);
    }

    @RequestMapping("/pageByNamexSqlCustomMap")
    @ResponseBody
    public Page<Map<String, Object>> pageByNamexSqlCustomMap(String name, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        return this.personService.pageByNamexSqlCustomMap(name, pageNumber, pageSize);
    }


    /*
    * execute
    * */

    @RequestMapping("/executeByAgexSql")
    @ResponseBody
    public Integer executeByAgexSql(Integer age) {
        return this.personService.executeByAgexSql(age);
    }

    @RequestMapping("/executeByAgexHql")
    @ResponseBody
    public Integer executeByAgexHql(Integer age) {
        return this.personService.executeByAgexHql(age);
    }
}
