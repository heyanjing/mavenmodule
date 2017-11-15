package com.he.spring.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by heyanjing on 2017/11/14 14:09.
 */
@Configuration
@ComponentScan(basePackages = "com.he.spring.web",
               excludeFilters = {
                     @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
                     @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
@PropertySource("classpath:config/config.properties")
public class RootConfig {
    @Value("${jdbc.driverClass}")
    private String driverClassName;

    @Value("${jdbc.jdbcUrl}")
    private String url;

    @Value("${jdbc.user}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    /**
     * 必须加上static
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer loadProperties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }

}
