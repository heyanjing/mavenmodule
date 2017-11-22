package com.he.spring.he11.basejpa.service;

import com.he.spring.he11.basejpa.dao.PersonDao;
import com.he.spring.he11.basejpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by heyanjing on 2017/11/22 10:57.
 */
@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonDao userDao;

    @Transactional
    @Override
    public void add(Person person) {
        userDao.add(person);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> listPersons() {
        return userDao.listPersons();
    }

}
