package com.he.spring.he10.jdbc_template;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by heyanjing on 2017/11/21 9:30.
 * <p>
 * 使用JdbcTemplate的一个常见的最佳实践（同时也是SimpleJdbcTemplate和NamedParameterJdbcTemplate 类的最佳实践）就是在Spring配置文件中配置一个DataSource实例，然后将这个共享的DataSource实例助于到你的DAO中去。 而JdbcTemplate的实例将在DataSource的setter方法中被创建。这样的话，DAO可能看上去像这样：
 * public class JdbcCorporateEventDao implements CorporateEventDao {
 * <p>
 * private JdbcTemplate jdbcTemplate;
 * <p>
 * public void setDataSource(DataSource dataSource) {
 * this.jdbcTemplate = new JdbcTemplate(dataSource);
 * }
 * <p>
 * // JDBC-backed implementations of the methods on the CorporateEventDao follow...
 * }
 * 相关的配置看上去就像这样。
 * <?xml version="1.0" encoding="UTF-8"?>
 * <beans xmlns="http://www.springframework.org/schema/beans"
 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 * xsi:schemaLocation="http://www.springframework.org/schema/beans
 * http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
 * <p>
 * <bean id="corporateEventDao" class="com.example.JdbcCorporateEventDao">
 * <property name="dataSource" ref="dataSource"/>
 * </bean>
 * <p>
 * <!-- the DataSource (parameterized for configuration via a PropertyPlaceHolderConfigurer) -->
 * <bean id="dataSource" destroy-method="close" class="org.apache.commons.dbcp.BasicDataSource">
 * <property name="driverClassName" value="${jdbc.driverClassName}"/>
 * <property name="url" value="${jdbc.url}"/>
 * <property name="username" value="${jdbc.username}"/>
 * <property name="password" value="${jdbc.password}"/>
 * </bean>
 * <p>
 * </beans>
 */
public class MyDao1 extends JdbcDaoSupport {
}
