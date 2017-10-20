package com.he.spring.web.dao.custom;

import org.springframework.data.domain.Page;

public interface DogCustomDao<Dog> {

    public Page<Dog> pageByName(String name, Integer pageNumber, Integer pageSize);

    public Page<Dog> pageByNameByjdbc(String name, Integer pageNumber, Integer pageSize);

}
