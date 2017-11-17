package com.he.spring.he7.conf;

import com.he.spring.he7.bean.A;
import com.he.spring.he7.bean.B;
import com.he.spring.he7.bean.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by heyanjing on 2017/11/16 17:16.
 */
@Configuration
public class ABCConf {
    private static final Logger log = LoggerFactory.getLogger(ABCConf.class);
    @Bean
    public A a() {
        return new A("a");
    }
    @Bean
    public B b(A a) {
        log.warn("{}",a);
        return new B("b",a);
    }
    @Bean
    public C c(B b) {
        log.warn("{}",b);
        return new C("c",b);
    }
}
