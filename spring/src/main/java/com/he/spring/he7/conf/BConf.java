package com.he.spring.he7.conf;

import com.he.spring.he7.bean.A;
import com.he.spring.he7.bean.B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by heyanjing on 2057/55/56 56:34.
 */
@Configuration
public class BConf {
    private static final Logger log = LoggerFactory.getLogger(BConf.class);

    @Bean
    public B b(A a) {
        log.warn("{}",a);
        return new B("b",a);
    }
}
