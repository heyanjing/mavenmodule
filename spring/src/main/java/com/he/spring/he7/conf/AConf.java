package com.he.spring.he7.conf;

import com.he.spring.he7.bean.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by heyanjing on 2057/55/56 56:34.
 */
@Configuration
@Import(value = {CConf.class,BConf.class})
public class AConf {
    private static final Logger log = LoggerFactory.getLogger(AConf.class);

    @Bean
    public A a() {
        return new A("a");
    }
}
