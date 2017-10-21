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
        String sql = "SELECT p.id,p.name,p.age,p.birthday FROM person p WHERE 1=1";
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        sql+=" order by name asc";
        return super.pageBySql(sql, params, pageNumber, pageSize);
    }

    /**
     * sql查询---List型参数
     */
    @Override
    public List<Person> findAllxSql(Integer age) {
        List<Object> params = Lists.newArrayList();
//        String sql = "SELECT p.* FROM person p where 1=1";// MEINFO:2017/10/21 14:42 这种写法也可以
        String sql = "SELECT p.id AS id,p.age AS age,p.birthday as birthday,p.name,(select d.name from dog d where d.name='dog1') as names FROM person p where 1=1";// MEINFO:2017/10/21 14:38 要返回
        if (age != null) {
            sql += " and p.age< ?";
            params.add(age);
        }

        sql+=" order by name asc";
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
        hql+=" order by name asc";
        return super.pageByHql(hql, params, pageNumber, pageSize);
    }

    /**
     * hql查询---List型参数
     */
    @Override
    public List<Person> findAllxHql(Integer age) {
        List<Object> params = Lists.newArrayList();
        String hql = "from Person p,Dog d where 1=1";
        if (age != null) {
            hql += " and age< ?";
            params.add(age);
        }
        hql+=" order by name asc";
        return super.findByHql(hql, params.toArray());
    }

    @Override
    public List<Person> findAllxHqlName(String name) {
        List<Object> params = Lists.newArrayList();
        String hql = "from Person where 1=1";
        if (name != null) {
            hql += " and name like ?";
            params.add("%"+name+"%");
        }
        hql+=" order by name asc";
        return super.findByHql(hql, params.toArray());
    }

    /*
        * custom
        * */
    @Override
    public Page<Dog> pageByNamexSqlCustom(String name, Integer pageNumber, Integer pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = "SELECT p.id ,p.age ,p.birthday ,p.name  FROM Person p WHERE 1=1";// MEINFO:2017/10/21 14:42 这种写法也可以
//        String sql = "SELECT p.id AS id,p.age AS age,p.birthday as birthday,p.`name` AS name FROM Person p WHERE 1=1";// MEINFO:2017/10/21 14:39 要返回
        if (name != null) {
            sql += " and p.`name` like :name";
            params.put("name", "%" + name + "%");
        }
        sql+=" order by name asc";
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
       hql+=" order by name asc";
        return super.pageEntityClassByHql(hql,Dog.class, params, pageNumber, pageSize);
    }

    @Override
    public List<Dog> findAllxSqlCustom(Integer age) {
        List<Object> params = Lists.newArrayList();
        String sql = "SELECT p.id ,p.age ,p.birthday ,p.name FROM person p where 1=1";// MEINFO:2017/10/21 14:42 这种写法也可以
//        String sql = "SELECT p.id AS id,p.age AS age,p.birthday as birthday,p.`name` AS name FROM person p where 1=1";// MEINFO:2017/10/21 14:39 要返回
        if (age != null) {
            sql += " and p.age< ?";
            params.add(age);
        }
        sql+=" order by name asc";
        return super.findEntityClassBySql(sql, Dog.class, params.toArray());
    }

    @Override
    public List<Dog> findAllxHqlCustom(Integer age) {
        List<Object> params = Lists.newArrayList();
//        String hql = "SELECT p.id,p.`name`,p.age,p.birthday,p.state,d.`name` AS names FROM Person p,Dog d WHERE p.id=d.id";// MEINFO:2017/10/21 17:19 hql多表查询
        String hql = "from Person where 1=1";
        if (age != null) {
            hql += " and age< ?";
            params.add(age);
        }
        hql+=" order by name asc";
        return super.findEntityClassByHql(hql,Dog.class, params.toArray());
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
        sql+=" order by name asc";
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
        sql+=" order by name asc";
        return super.findListMapBySql(sql, params.toArray());
    }


    /*
    * execute
    * */
    @Override
    public int executeByAgexSql(Integer age) {
        Map<String, Object> params = Maps.newHashMap();
        String sql = " update Person set name=:name,state=:state where 1=1 ";
        params.put("name", "name" + age);
        params.put("state", age);
        if (age != null) {
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
