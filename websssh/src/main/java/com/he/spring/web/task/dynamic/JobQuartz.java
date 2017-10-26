package com.he.spring.web.task.dynamic;

import com.he.maven.module.utils.Dates;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by heyanjing on 2017/10/26 15:42.
 */
public class JobQuartz extends QuartzJobBean {
    private static final Logger log = LoggerFactory.getLogger(JobQuartz.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("JobQuartz-----"+Dates.newDateString("yyyy-MM-dd HH:mm:ss"));
    }
}
