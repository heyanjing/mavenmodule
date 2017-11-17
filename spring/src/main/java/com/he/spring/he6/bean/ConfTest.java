package com.he.spring.he6.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by heyanjing on 2017/11/17 10:32.
 */
@Component
public class ConfTest {
    private static final Logger log = LoggerFactory.getLogger(ConfTest.class);
    //-Dspring.profiles.default=config1 -Dspring.profiles.active=config2


    @Value("${config.name}")
    String name;

    @PostConstruct
    public void init() {

        log.error(name);
        ApplicationContext ctx = new GenericApplicationContext();
        Environment env = ctx.getEnvironment();
        log.info("{}", env.containsProperty("spring.profiles.active"));
    }
}
