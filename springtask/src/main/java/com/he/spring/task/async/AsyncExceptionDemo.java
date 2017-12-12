package com.he.spring.task.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by heyanjing on 2017/12/11 15:50.
 */
@Component
public class AsyncExceptionDemo {
    private static final Logger log = LoggerFactory.getLogger(AsyncExceptionDemo.class);

    @Async
    public void asyncInvokeSimplest() {
        log.info("asyncSimplest");
    }

    @Async
    public void asyncInvokeWithException(String s) {
        log.info("asyncInvokeWithParameter, parementer={}", s);
        throw new IllegalArgumentException(s);
    }

    @Async
    public Future<String> asyncInvokeReturnFuture(int i) {
        log.info("asyncInvokeReturnFuture, parementer={}", i);
        Future<String> future;
        try {
            Thread.sleep(1000 * 1);
            future = new AsyncResult<String>("success:" + i);
            throw new IllegalArgumentException("a");
        } catch (InterruptedException e) {
            future = new AsyncResult<String>("error");
        } catch(IllegalArgumentException e){
            future = new AsyncResult<String>("error-IllegalArgumentException");
        }
        return future;
    }

}
