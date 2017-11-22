package com.he.spring.he11.jpa.dao;

import com.he.spring.he11.entities.Persons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by heyanjing on 2017/11/21 15:29.
 */
@Repository
public class PersonsDao {
    private static final Logger log = LoggerFactory.getLogger(PersonsDao.class);

    @PersistenceContext
    private EntityManager em;


    public void save(){
        Persons p=new Persons();
        p.setUser_name("name_jap");
        p.setAge(1);
        this.em.persist(p);
    }
    public void list(){
        List resultList = this.em.createNativeQuery("select * from Person").getResultList();
        log.info("{}",resultList);
        List list = this.em.createQuery("from persons").getResultList();
        log.info("{}",list);
    }

}
