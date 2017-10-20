package com.he.spring.web.dao.impl;

import com.he.maven.module.data.hibernate.BaseHibernateDao;
import com.he.spring.entity.User;
import com.he.spring.web.dao.custom.UserCustomDao;
import org.springframework.data.domain.Page;

import java.util.List;

public class UserDaoImpl extends BaseHibernateDao<User> implements UserCustomDao<User> {

    @Override
    public Page<User> pageByNamex(String name, Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public List<User> findAllx() {
        String hql = "from User ";
        return super.findByHql(hql);
    }
}
