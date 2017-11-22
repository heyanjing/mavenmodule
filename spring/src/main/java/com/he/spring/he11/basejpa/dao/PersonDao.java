package com.he.spring.he11.basejpa.dao;

import com.he.spring.he11.basejpa.entity.Person;

import java.util.List;

/**
 * Created by heyanjing on 2017/11/22 10:55.
 */
public interface PersonDao {
    void add(Person person);
    List<Person> listPersons();
}
