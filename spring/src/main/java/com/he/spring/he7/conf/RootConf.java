package com.he.spring.he7.conf;

import com.he.spring.he7.annotationbean.Bean1;
import com.he.spring.he7.bean.Field1;
import com.he.spring.he7.bean.Field2;
import com.he.spring.he7.bean.Field3;
import com.he.spring.he7.bean.Field4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;

/**
 * Created by heyanjing on 2017/11/16 14:34.
 */
@Configuration
@ComponentScan(basePackages = {"com.he.spring.he7.annotationbean"})
@PropertySource("classpath:/he7/config1.propertes")
public class RootConf {
    private static final Logger log = LoggerFactory.getLogger(RootConf.class);

    @Autowired
    Environment env;

    // MEINFO:2017/11/16 16:07 注解内的值都是默认值
    @Bean(name = "field1")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.NO)
    public Field1 field1() {
        log.info("{}",env.getProperty("config.name"));
        Field1 field1 = new Field1();
        field1.setName("field1");
        return field1;
    }

    // MEINFO:2017/11/16 15:53 默认情况下bean有 public 的close或shutdown方法会在bean销毁后自动调用
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Field2 field2() {
        Field2 field2 = new Field2();
        field2.setField1(field1());
        field2.setName("field2");
        return field2;
    }
   /* 注册两个Field2 的bean不会出错，但是在使用的时候就会报错 No qualifying bean of type 'com.he.spring.he7.bean.Field2' available: expected single matching bean but found 2: field2,field2x
   @Bean(initMethod = "init", destroyMethod = "destory")
    public Field2 field2x() {
        Field2 field2 = new Field2();
        field2.setField1(field1());
        field2.setName("field2x");
        return field2;
    }*/

    // MEINFO:2017/11/16 15:35 在该配置文件中，有参数对应的bean时，自动依赖注入（包括扫描包的bean）,     Field5 field5直接报错
    @Bean
    public Field3 field3(Field1 field1x, Bean1 bean1/*,Field5 field5*/) {
        log.warn("{}",field1x);
        log.warn("{}",bean1);
//        log.warn("{}",field5);
        Field3 field3 = new Field3(field1x);
        field3.setName("field3");
        return field3;
    }
    @Bean
    public Field4 field4() {
        Field4 field4 = new Field4(field1());
        field4.setName("field4");
        return field4;
    }

}
