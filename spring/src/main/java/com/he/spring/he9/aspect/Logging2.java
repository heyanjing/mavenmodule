package com.he.spring.he9.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/11/18 21:05.
 */
@Aspect
public class Logging2 {
    private static final Logger log = LoggerFactory.getLogger(Logging2.class);
    @Pointcut("execution(* com.he.spring.he9.bean.Student2.*(..))")
    private void pointcut() {}

    @Before(value = "pointcut()")
    public void beforeAdvice(){
        log.info("Logging2------beforeAdvice");
    }
    @After(value = "pointcut()")
    public void afterAdvice(){
        log.info("Logging2------afterAdvice");
    }
    @AfterReturning(value = "pointcut()",returning ="retVal" )
    public void afterReturningAdvice(Object retVal){
        log.info("Logging2------afterReturningAdvice"+retVal );
    }
    @AfterThrowing(value = "pointcut()",throwing = "ex")
    public void AfterThrowingAdvice(Exception ex){
        log.info("Logging2------AfterThrowingAdvice");
    }
}
