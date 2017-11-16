package com.he.spring.he6.bean;

import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/11/16 11:36.
 */
@Component
public class A1 implements A {

    @Override
    public void say() {
        log.info("A1");
    }
}
