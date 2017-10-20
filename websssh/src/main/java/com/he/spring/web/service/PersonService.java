package com.he.spring.web.service;

import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import com.he.spring.web.dao.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonDao personDao;

    /*
    *  person相关
    */
    public Person save(Person person) {
        person.setName("我操1");
        Person p1 = personDao.save(person);//保存
        p1.setName("我操2");
        Person p2 = personDao.save(p1);//更新


//        Person p1 = this.personDao.get("adc68578-12ab-4e65-b918-0b16fc803606");//获取
//        p1.setName("我操5");
//        Person p2 = this.personDao.save(p1);//更新


        return p2;
    }

    public List<Person> findAll() {
        return this.personDao.findAll();
    }

    /*
    * T
    * */
    public List<Person> findAllxSql(Integer age) {
        return this.personDao.findAllxSql(age);
    }

    public Page<Person> pageByNamexSql(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexSql(name, pageNumber, pageSize);
    }

    public List<Person> findAllxHql(Integer age) {
        return this.personDao.findAllxHql(age);
    }

    public Page<Person> pageByNamexHql(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexHql(name, pageNumber, pageSize);
    }

    /*
    * custom
    * */
    public List<Dog> findAllxSqlCustom(Integer age) {
        return this.personDao.findAllxSqlCustom(age);
    }

    public Page<Dog> pageByNamexSqlCustom(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexSqlCustom(name, pageNumber, pageSize);
    }

    public List<Dog> findAllxHqlCustom(Integer age) {
        return this.personDao.findAllxHqlCustom(age);
    }

    public Page<Dog> pageByNamexHqlCustom(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexHqlCustom(name, pageNumber, pageSize);
    }

    /*
    * execute
    * */
    public int executeByAgexSql(Integer age) {
        return this.personDao.executeByAgexSql(age);
    }

    public int executeByAgexHql(Integer age) {
        return this.personDao.executeByAgexHql(age);
    }

    /*
    * map
    * */
    public Page<Map<String, Object>> pageByNamexSqlCustomMap(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexSqlCustomMap(name, pageNumber, pageSize);
    }


    public List<Map<String, Object>> findAllxSqlCustomMap(Integer age) {
        return this.personDao.findAllxSqlCustomMap(age);
    }

}
