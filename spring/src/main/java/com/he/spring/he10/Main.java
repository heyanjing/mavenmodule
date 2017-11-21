package com.he.spring.he10;

import com.he.spring.he10.jdbc_template.MyDao1;
import com.he.spring.he10.named_parameter_jdbc_template.Person;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by heyanjing on 2017/11/21 9:02.
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("he10/spring.xml");
        //region Description使用JdbcTemplate
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        log.info("{}", jdbcTemplate.queryForObject("select count(*) from person", Integer.class));
        MyDao1 myDao1 = context.getBean("myDao1", MyDao1.class);
        log.info("{}", myDao1.getJdbcTemplate().queryForObject("select count(*) from person", Integer.class));
        //endregion


        //region Description使用NamedParameterJdbcTemplate
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = context.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
        String sql = "select count(0) from person where name like :name";
//        MapSqlParameterSource
        SqlParameterSource namedParameters1 = new MapSqlParameterSource("name", "%name8%");
        log.info("{}", namedParameterJdbcTemplate.queryForObject(sql, namedParameters1, Integer.class));
//Map  常用
        Map<String, Object> map = Collections.singletonMap("name", "%name8%");
        log.info("{}", namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class));
//        BeanPropertySqlParameterSource
        Person p = new Person();
        p.setName("%name8%");
        SqlParameterSource namedParameters2 = new BeanPropertySqlParameterSource(p);
        log.info("{}", namedParameterJdbcTemplate.queryForObject(sql, namedParameters2, Integer.class));
        //endregion


//
        String sqlx = "select * from person WHERE age>?";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sqlx, 5);//
        log.warn("{}", mapList);
        List<Person> personList = jdbcTemplate.query(sqlx, BeanPropertyRowMapper.newInstance(Person.class), 5);//
        log.warn("{}", personList);


        ComboPooledDataSource dataSource = context.getBean("dataSource", ComboPooledDataSource.class);
        log.info("{}",dataSource);
    }
}
