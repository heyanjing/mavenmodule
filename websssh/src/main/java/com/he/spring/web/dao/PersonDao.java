package com.he.spring.web.dao;

import com.he.maven.module.data.repo.BaseRepo;
import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import com.he.spring.web.dao.custom.PersonCustomDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

/*
* JP QL
* */
public interface PersonDao extends BaseRepo<Person, String>, PersonCustomDao<Person> {
    public Person getById(String id);

    @Query(value = "select  * from Person  where  state=8 and id=?1", nativeQuery = true)
    public Person getByIdSql(String id);

    @Query("from Person where id=?1")
    public Person getByIdHql(String id);

    /**
     * 写类似hql ,问号+数字占位
     */
    @Query("select t from Person t where t.id = ?1")
    public Person getByIdx1(String id);

    /**
     * 写sql,问号+数字占位
     */
    @Query(value = "select * from person t where t.id = ?1", nativeQuery = true)
    public Person getByIdx2(String id);

    /**
     * 写类似hql,占位符占位
     * 可以写成 from Person t where t.id = :id
     */
    @Query(value = "select  t from Person t where t.id = :id")
    public Person getByIdx3(@Param("id") String id);

    /**
     * 修改
     */
    @Modifying
    @Query("update Person t set t.name = ?1 where t.id = ?2")
    public Integer updateNameByIdx(String name, String id);

    @Query(value = "SELECT  p FROM  Person p where p.age=?1")
    public Page<Person> pageByAge(Integer age, Pageable pageable);

}
