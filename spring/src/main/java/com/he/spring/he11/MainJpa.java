package com.he.spring.he11;

import com.he.spring.he11.jpa.dao.PersonsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heyanjing on 2017/11/21 9:02.
 */
public class MainJpa {
    private static final Logger log = LoggerFactory.getLogger(MainJpa.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("he11/spring-jpa.xml");
        PersonsDao usersDao = context.getBean(PersonsDao.class);
        usersDao.save();

        usersDao.list();
    }
}
