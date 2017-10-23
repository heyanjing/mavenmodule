package com.he.spring.web.service;

import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import com.he.spring.web.dao.DogDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private static final Logger log = LoggerFactory.getLogger(DogService.class);

    @Autowired
    private DogDao dogDao;


    /*
     * dog相关
     */
    public Dog save(Dog dog) {
        return this.dogDao.save(dog);
    }

    public Page<Dog> pageByName(String name, Integer pageNumber, Integer pageSize) {
        return this.dogDao.pageByName(name, pageNumber, pageSize);
    }

    public List<Dog> findByName(String name) {
        return this.dogDao.findByName(name);
    }

    public Page<Person> pageByNameCustom(String name, Integer pageNumber, Integer pageSize) {
        return this.dogDao.pageByNameCustom(name, pageNumber, pageSize);
    }

    public List<Person> findByNameCustom(String name) {
        return this.dogDao.findByNameCustom(name);
    }

}
