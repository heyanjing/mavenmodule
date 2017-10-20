package com.he.spring.web.service;

import com.he.spring.entity.User;
import com.he.spring.web.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;


   /*
    * user相关
    */
   public User save(User user) {
       User p = userDao.save(user);
       return p;
   }
   public List<User> findAllx() {
       return this.userDao.findAllx();
   }
}
