package com.he.spring.web.dao.custom;

import com.he.spring.entity.Dog;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface PersonCustomDao<Person> {

    public Page<Person> pageByNamexSql(String name, Integer pageNumber, Integer pageSize);

    public Page<Person> pageByNamexHql(String name, Integer pageNumber, Integer pageSize);

    public List<Person> findAllxSql(Integer age);

    public List<Person> findAllxHql(Integer age);

    public List<Person> findAllxHqlName(String name);

    public Page<Dog> pageByNamexSqlCustom(String name, Integer pageNumber, Integer pageSize);

    public Page<Dog> pageByNamexHqlCustom(String name, Integer pageNumber, Integer pageSize);

    public List<Dog> findAllxSqlCustom(Integer age);

    public List<Dog> findAllxHqlCustom(Integer age);

    public int executeByAgexSql(Integer age);

    public int executeByAgexHql(Integer age);

    public Page<Map<String, Object>> pageByNamexSqlCustomMap(String name, Integer pageNumber, Integer pageSize);

    public List<Map<String, Object>> findAllxSqlCustomMap(Integer age);


}
