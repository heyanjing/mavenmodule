package com.he.spring.he9.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/11/18 21:05.
 */
public class Logging {
    private static final Logger log = LoggerFactory.getLogger(Logging.class);
    public void beforeAdvice(){
        log.info("Logging------beforeAdvice");
    }
    public void afterAdvice(){
        log.info("Logging------afterAdvice");
    }
    public void afterReturningAdvice(Object retVal){
        log.info("Logging------afterReturningAdvice"+retVal );
    }
    public void AfterThrowingAdvice(Exception ex){
        log.info("Logging------AfterThrowingAdvice");
    }
}
