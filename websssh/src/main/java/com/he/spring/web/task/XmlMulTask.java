package com.he.spring.web.task;

import com.he.maven.module.data.util.Springs;
import com.he.maven.module.utils.Dates;
import com.he.maven.module.utils.Logs;
import com.mchange.v2.c3p0.PooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by heyanjing on 2017/10/26 14:08.
 */
@Component
public class XmlMulTask {
    private static final Logger log = LoggerFactory.getLogger(XmlMulTask.class);
    private PooledDataSource pooledDatasource;

    public void c3p0() throws Exception {
        log.info( "任务三执行开始..........."+ Dates.newDateString("yyyy-MM-dd HH:mm:ss"));
        if (this.pooledDatasource == null) {
            this.pooledDatasource = Springs.getBean("dataSource");
        }
        String msg = "";
        msg += "============================== 数据源状态报告 ==============================\n";
        msg += "CurrentTime：" + Dates.newDateString("yyyy-MM-dd HH:mm:ss.SSS") + "\n";
        msg += "TotalConnections：" + this.pooledDatasource.getNumConnectionsAllUsers() + "\n";
        msg += "BusyConnections：" + this.pooledDatasource.getNumBusyConnectionsAllUsers() + "\n";
        msg += "IdleConnections：" + this.pooledDatasource.getNumIdleConnectionsAllUsers() + "\n";
        msg += "FailedCheckins：" + this.pooledDatasource.getNumFailedCheckinsDefaultUser() + "\n";
        msg += "FailedCheckouts：" + this.pooledDatasource.getNumFailedCheckoutsDefaultUser() + "\n";
        msg += "FailedIdleTests：" + this.pooledDatasource.getNumFailedIdleTestsDefaultUser() + "\n";
        msg += "UnclosedOrphanedConnections：" + this.pooledDatasource.getNumUnclosedOrphanedConnectionsAllUsers() + "\n";
        msg += "StatementCacheNumStatements：" + this.pooledDatasource.getStatementCacheNumStatementsAllUsers() + "\n";
        msg += "StatementCacheNumCheckedOutStatements：" + this.pooledDatasource.getStatementCacheNumCheckedOutStatementsAllUsers() + "\n";
        msg += "StatementCacheNumConnectionsWithCachedStatements：" + this.pooledDatasource.getStatementCacheNumConnectionsWithCachedStatementsAllUsers() + "\n";
        msg += "============================== 数据源状态报告 ==============================";
        System.out.println(msg);
        log.info( "任务三执行开始..........."+Dates.newDateString("yyyy-MM-dd HH:mm:ss"));
    }

    public void test1() throws Exception {

        log.info( "任务一执行开始..........."+Dates.newDateString("yyyy-MM-dd HH:mm:ss"));

        TimeUnit.SECONDS.sleep(10);
        log.info( "任务一执行结束..........."+Dates.newDateString("yyyy-MM-dd HH:mm:ss"));
    }

    public void test2() throws Exception {

        Logs.info(this, "任务二执行开始..........."+Dates.newDateString("yyyy-MM-dd HH:mm:ss"));
        Logs.info(this, "任务二执行结束..........."+Dates.newDateString("yyyy-MM-dd HH:mm:ss"));
    }
}
