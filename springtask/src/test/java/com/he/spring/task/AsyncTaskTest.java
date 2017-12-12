package com.he.spring.task;

import com.he.spring.task.async.AsyncDemo;
import com.he.spring.task.async.AsyncExceptionDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by heyanjing on 2017/12/11 11:17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
public class AsyncTaskTest {
    private static final Logger log = LoggerFactory.getLogger(AsyncTaskTest.class);
    @Autowired
    AsyncDemo asyncDemo;
    @Autowired
    AsyncExceptionDemo exceptionDemo;

    @Test
    public void test() {
        asyncDemo.asyncInvokeSimplest();
        asyncDemo.asyncInvokeWithParameter("test");
        Future<String> future = asyncDemo.asyncInvokeReturnFuture(100);

        try {
            log.info("有参数  有返回值，返回值{}",future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testEx() {
        exceptionDemo.asyncInvokeSimplest();
        exceptionDemo.asyncInvokeWithException("test");
        Future<String> future = exceptionDemo.asyncInvokeReturnFuture(100);
        try {
            log.info(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}