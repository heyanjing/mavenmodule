package com.he.spring.he11.basejpa.service;

import com.he.spring.he11.basejpa.entity.Person;

import java.util.List;

/**
 * Created by heyanjing on 2017/11/22 10:56.
 */
public interface PersonService {
    void add(Person person);
    List<Person> listPersons();
}
