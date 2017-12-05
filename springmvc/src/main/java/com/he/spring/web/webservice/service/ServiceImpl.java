package com.he.spring.web.webservice.service;

import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heyanjing on 2017/12/4 16:47.
 */
@WebService
@Component
public class ServiceImpl implements IService {

    private static Map<String, Person> persons = new HashMap<>();

    static {
        persons.put("name1", new Person("name1", 1, new Date()));
        persons.put("name2", new Person("name2", 2, new Date()));
        persons.put("name3", new Person("name3", 3, new Date()));
    }

    @Override
    public Person getPerson(String name) {
        return persons.get(name);
    }
}
