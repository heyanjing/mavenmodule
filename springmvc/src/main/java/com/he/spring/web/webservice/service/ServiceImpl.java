package com.he.spring.web.webservice.service;

import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.Date;

/**
 * Created by heyanjing on 2017/12/4 16:47.
 */
@WebService
@Component
public class ServiceImpl implements IService {

    @Override
    public Person getPerson(String name) {
        return new Person(name,22,new Date());
    }
}
