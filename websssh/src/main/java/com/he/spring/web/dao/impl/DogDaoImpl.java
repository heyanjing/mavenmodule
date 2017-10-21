package com.he.spring.web.dao.impl;

import com.google.common.collect.Maps;
import com.he.maven.module.data.jdbc.BaseJdbcDao;
import com.he.spring.entity.Dog;
import com.he.spring.web.dao.custom.DogCustomDao;
import org.springframework.data.domain.Page;

import java.util.Map;

public class DogDaoImpl extends BaseJdbcDao<Dog> implements DogCustomDao<Dog> {

    @Override
    public Page<Dog> pageByName(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT * FROM dog p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name`=:name";
            params.put("name", name);
        }
        return super.pageBySql(sql, pageNumber, pageSize, params);
    }

    @Override
    public Page<Dog> pageByNameByjdbc(String name, Integer pageNumber, Integer pageSize) {

        return null;
    }

}
