package com.he.spring.web.webservice.service;

import java.util.Date;

/**
 * Created by heyanjing on 2017/12/5 9:51.
 */
public class SimpleServiceImpl implements  ISimpleService {
    @Override
    public Person getPerson(String name) {
        return new Person(name,22,new Date());
    }
}
