package com.he.spring.web.service;

import com.he.spring.web.dao.DogDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {
    private static final Logger log = LoggerFactory.getLogger(DogService.class);

    @Autowired
    private DogDao dogDao;

   /*
    * dog相关
    */


}
