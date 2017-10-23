package com.he.spring.web.dao.impl;

import com.google.common.collect.Maps;
import com.he.maven.module.data.jdbc.BaseJdbcDao;
import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import com.he.spring.web.dao.custom.DogCustomDao;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public class DogDaoImpl extends BaseJdbcDao<Dog> implements DogCustomDao<Dog> {

    @Override
    public List<Dog> findByName(String name) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT * FROM dog p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        sql += " order by age asc";
        return super.findBySql(sql, params);
    }

    @Override
    public Page<Dog> pageByName(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT * FROM dog p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        sql += " order by age asc";
        return super.pageBySql(sql, pageNumber, pageSize, params);
    }

    @Override
    public Page<Person> pageByNameCustom(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT * FROM dog p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        sql += " order by age asc";
        return super.pageBySql(sql, Person.class, pageNumber, pageSize, params);
    }

    @Override
    public List<Person> findByNameCustom(String name) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT * FROM dog p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        sql += " order by age asc";
        return super.findBySql(sql, Person.class, params);
    }


}
