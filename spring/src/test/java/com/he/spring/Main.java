package com.he.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Created by heyanjing on 2017/11/17 8:53.
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        StopWatch sw = new StopWatch(Main.class.getName());
        sw.start("main");
        log.debug("{}",args);
        log.info("{}",System.getProperty("uu"));
        log.warn("{}",System.getenv());
        log.info("{}",System.getProperties());
        sw.stop();

//        StopWatch 'com.he.spring.Main': running time (millis) = 76
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00076  100%  main
        log.error("\n"+sw.prettyPrint());
    }
}
