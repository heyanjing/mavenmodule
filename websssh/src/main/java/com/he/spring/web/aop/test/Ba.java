package com.he.spring.web.aop.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/10/26 10:26.
 */
@Component
public class Ba  {
    private static final Logger log = LoggerFactory.getLogger(Ba.class);
    public void say() {
        log.warn("Ba---say");
    }
}


