package com.he.spring.he11.hibernate.dao;

import com.he.spring.he11.entities.Users;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * Created by heyanjing on 2017/11/21 15:29.
 */
@Repository
public class UsersDao {
    private static final Logger log = LoggerFactory.getLogger(UsersDao.class);

    @Autowired
    private SessionFactory sessionFactory;
    public void save(){
        Users p=new Users();
        p.setUser_name("name_hibernate");
        p.setAge(1);
        this.sessionFactory.getCurrentSession().save(p);
    }
    public void list(){
        List list = this.sessionFactory.getCurrentSession().createQuery("from com.he.spring.he11.entities.Users").list();
        log.info("{}",list);
    }

}
