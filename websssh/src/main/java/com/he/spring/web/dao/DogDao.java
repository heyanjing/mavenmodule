package com.he.spring.web.dao;

import com.he.maven.module.data.repo.BaseRepo;
import com.he.spring.entity.Dog;
import com.he.spring.web.dao.custom.DogCustomDao;

public interface DogDao extends BaseRepo<Dog, String>, DogCustomDao<Dog> {

}
