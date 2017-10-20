package com.he.spring.web.dao;

import com.he.maven.module.data.repo.BaseRepo;
import com.he.spring.entity.User;
import com.he.spring.web.dao.custom.UserCustomDao;

public interface UserDao extends BaseRepo<User, String>, UserCustomDao<User> {



}
