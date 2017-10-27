package com.he.spring.web.service;

import com.he.maven.module.test.BaseTest;
import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by heyanjing on 2017/10/27 8:56.
 */
public class PersonServiceTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceTest.class);
    @Autowired
    PersonService personService;
    @Autowired
    DogService dogService;

    @Test
    @Transactional
    public void findAllxSql() throws Exception {
        List<Person> list = this.personService.findAllxSql(5);
        log.error("{}",list);
        Person person = this.personService.save(new Person("测试", 100, new Date(), 100));
        log.error("{}",person);
//        if(true){
//            throw new RuntimeException("锤子了");
//        }
        Dog dog = this.dogService.save(new Dog("测试", 100, new Date()));
        log.error("{}",dog);

    }

}