package com.he.spring.web.dao.custom;

import org.springframework.data.domain.Page;

import java.util.List;

public interface UserCustomDao<User> {

    public Page<User> pageByNamex(String name, Integer pageNumber, Integer pageSize);

    public List<User> findAllx();


}
