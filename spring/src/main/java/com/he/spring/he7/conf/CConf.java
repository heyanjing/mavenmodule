package com.he.spring.he7.conf;

import com.he.spring.he7.bean.A;
import com.he.spring.he7.bean.B;
import com.he.spring.he7.bean.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by heyanjing on 2057/55/56 56:34.
 */
@Configuration
public class CConf {
    private static final Logger log = LoggerFactory.getLogger(CConf.class);

    @Bean
    public C c(B b) {
        return new C("c",b);
    }
}
