package com.he.spring.web.dao.custom;

import com.he.spring.entity.Person;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DogCustomDao<Dog> {

    public Page<Dog> pageByName(String name, Integer pageNumber, Integer pageSize);

    public List<Dog> findByName(String name);

    public Page<Person> pageByNameCustom(String name, Integer pageNumber, Integer pageSize);

    public List<Person> findByNameCustom(String name);


}
