package com.he.spring.web.aop.test.aspect;

import com.he.maven.module.utils.Logs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/5/19 14:29.
 */
@Component
@Aspect
public class TestAspect {
    private static final Logger log = Logs.getLogger(TestAspect.class);

    private String prefix="test========";

    @Pointcut("execution(* com.he.spring.web.aop..*.*(..))")
    public void pointcut() {
    }

    //在目标方法开始之前执行
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.warn(this.prefix+"before前置通知");
    }

    //在目标方法执行后执行（发生异常也执行） 不能获取目标方法执行后的结果
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        log.warn(this.prefix+"after后置通知");
    }

    //在目标方法正常执行(不出异常)完后执行，returnValue为目标方法的返回结果
    @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        log.warn(this.prefix+"afterReturning返回通知");
    }

    //在目标方法执行时出现异常时执行，可以指定出现特定异常才执行
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.warn(this.prefix+"afterThrowing异常通知");
    }
}
