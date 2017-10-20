package com.he.spring.web.dao.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.he.maven.module.data.hibernate.BaseHibernateDao;
import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import com.he.spring.web.dao.custom.PersonCustomDao;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public class PersonDaoImpl extends BaseHibernateDao<Person> implements PersonCustomDao<Person> {

    /*
    * T
    * */

    /**
     * sql分页---map型参数
     */
    @Override
    public Page<Person> pageByNamexSql(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT * FROM person p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        return super.pageBySql(sql, params, pageNumber, pageSize);
    }

    /**
     * sql查询---List型参数
     */
    @Override
    public List<Person> findAllxSql(Integer age) {
        List<Object> params = Lists.newArrayList();
        String sql = "SELECT p.id AS id,p.age AS age,p.birthday as birthday,p.`name` AS name FROM person p where 1=1";
        if (age != null) {
            sql += " and p.age< ?";
            params.add(age);
        }
        return super.findBySql(sql, params.toArray());

    }

    /**
     * hql分页---map型参数
     */
    @Override
    public Page<Person> pageByNamexHql(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String hql = " from Person  where 1=1";
        if (name != null) {
            hql += " and name like :name";
            params.put("name", "%" + name + "%");
        }
        return super.pageByHql(hql, params, pageNumber, pageSize);
    }

    /**
     * hql查询---List型参数
     */
    @Override
    public List<Person> findAllxHql(Integer age) {
        List<Object> params = Lists.newArrayList();
        String hql = "from Person where 1=1";
        if (age != null) {
            hql += " and age< ?";
            params.add(age);
        }
        return super.findByHql(hql, params.toArray());
    }

    /*
    * custom
    * */
    @Override
    public Page<Dog> pageByNamexSqlCustom(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT * FROM Person p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        return super.pageEntityClassBySql(sql, params, Dog.class, pageNumber, pageSize);
    }

    @Override
    public Page<Dog> pageByNamexHqlCustom(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String hql = " from Person  where 1=1";
        if (name != null) {
            hql += " and name like :name";
            params.put("name", "%" + name + "%");
        }
        return super.pageEntityClassByHql(hql, params, pageNumber, pageSize);
    }

    @Override
    public List<Dog> findAllxSqlCustom(Integer age) {
        List<Object> params = Lists.newArrayList();
        String sql = "SELECT p.id AS id,p.age AS age,p.birthday as birthday,p.`name` AS name FROM person p where 1=1";
        if (age != null) {
            sql += " and p.age< ?";
            params.add(age);
        }
        return super.findEntityClassBySql(sql, Dog.class, params.toArray());
    }

    @Override
    public List<Dog> findAllxHqlCustom(Integer age) {
        List<Object> params = Lists.newArrayList();
        String hql = "from Person where 1=1";
        if (age != null) {
            hql += " and age< ?";
            params.add(age);
        }
        return super.findEntityClassByHql(hql, params.toArray());
    }
    /*
    * map
    * */

    @Override
    public Page<Map<String, Object>> pageByNamexSqlCustomMap(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT * FROM Person p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        return super.pageListMapBySql(sql, params, pageNumber, pageSize);
    }


    @Override
    public List<Map<String, Object>> findAllxSqlCustomMap(Integer age) {
        List<Object> params = Lists.newArrayList();
        String sql = "SELECT p.id AS id,p.age AS age,p.birthday as birthday,p.`name` AS name FROM person p where 1=1";
        if (age != null) {
            sql += " and p.age< ?";
            params.add(age);
        }
        return super.findListMapBySql(sql, params.toArray());
    }


    /*
    * execute
    * */
    @Override
    public int executeByAgexSql(Integer age) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = " update Person set name=:name where 1=1 ";
        if (age != null) {
            params.put("name", "name" + age);
            sql += " and age=:age";
            params.put("age", age);
        }
        int i = super.executeUpdateBySql(sql, params);
        return i;
    }

    @Override
    public int executeByAgexHql(Integer age) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = " update Person set name=:name where 1=1 ";
        if (age != null) {
            params.put("name", "name" + age);
            sql += " and age=:age";
            params.put("age", age);
        }
        int i = super.executeUpdateByHql(sql, params);
        return i;
    }
}
