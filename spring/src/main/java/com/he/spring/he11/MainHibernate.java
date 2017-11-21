package com.he.spring.he11;

import com.he.spring.he11.hibernate.dao.UsersDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heyanjing on 2017/11/21 9:02.
 */
public class MainHibernate {
    private static final Logger log = LoggerFactory.getLogger(MainHibernate.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("he11/spring-hibernate.xml");
        UsersDao usersDao = context.getBean(UsersDao.class);
        usersDao.save();

        usersDao.list();
    }
}
