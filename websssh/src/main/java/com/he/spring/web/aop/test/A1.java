package com.he.spring.web.aop.test;

import com.he.spring.web.aop.test.Interface.IA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/10/26 10:26.
 */
@Component
public class A1 implements IA {
    private static final Logger log = LoggerFactory.getLogger(A1.class);
    @Override
    public void say() {
        log.warn("A1---say");
    }
}


