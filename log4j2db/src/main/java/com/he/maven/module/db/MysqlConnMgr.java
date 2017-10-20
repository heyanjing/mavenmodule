package com.he.maven.module.db;


import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * mysql的链接管理，用于日志写入数据库
 *在log4j2 中的 JDBC中配置
 */
public class MysqlConnMgr {
    private static interface Singleton {
        final MysqlConnMgr INSTANCE = new MysqlConnMgr();
    }

    private DataSource dataSource;

    private MysqlConnMgr() {
        try {
            InputStream stream = MysqlConnMgr.class.getClassLoader().getResourceAsStream("mysql-jdbc.properties");
            Properties props = new Properties();
            props.load(stream);
            String driver = props.getProperty("driverClassName");
            String  url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            Class.forName(driver);

            GenericObjectPool pool = new GenericObjectPool();
            DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url, user, password);
            new PoolableConnectionFactory(connectionFactory, pool, null, "SELECT 1", 3, false, false, Connection.TRANSACTION_READ_COMMITTED);
            this.dataSource = new PoolingDataSource(pool);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}
