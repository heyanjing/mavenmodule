package com.he.spring.he7.conf;

import com.he.spring.he7.annotationbean.Bean1;
import com.he.spring.he7.bean.Field5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by heyanjing on 2057/55/56 56:34.
 */
@Configuration
@Import(value = {Bean1.class,/*RootConf.class也可以*/})
public class OtherConf {
    private static final Logger log = LoggerFactory.getLogger(OtherConf.class);

    @Bean
    public Field5 field5( Bean1 bean1) {
        log.warn("{}", bean1);
        Field5 field5 = new Field5( bean1);
        field5.setName("field5");
        return field5;
    }
}
