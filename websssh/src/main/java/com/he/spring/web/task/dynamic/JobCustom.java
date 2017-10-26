package com.he.spring.web.task.dynamic;

import com.he.maven.module.utils.Dates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/10/26 15:42.
 */
public class JobCustom {
    private static final Logger log = LoggerFactory.getLogger(JobCustom.class);

    public void execute(){
        log.info("JobCustom-----"+ Dates.newDateString("yyyy-MM-dd HH:mm:ss"));
    }
}
