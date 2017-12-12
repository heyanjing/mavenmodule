package com.he.spring.task.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by heyanjing on 2017/12/11 15:42.
 */
@Component
public class AsyncDemo {
    private static final Logger log = LoggerFactory.getLogger(AsyncDemo.class);

    @Async
    public void asyncInvokeSimplest() {
        log.info("无参数  无返回值");
    }

    @Async
    public void asyncInvokeWithParameter(String s) {
        log.info("有参数  无返回值, parementer={}", s);
    }

    @Async
    public Future<String> asyncInvokeReturnFuture(int i) {
        log.info("有参数  有返回值, parementer={}", i);
        Future<String> future;
        try {
            Thread.sleep(1000 * 1);
            future = new AsyncResult<String>("success:" + i);
        } catch (InterruptedException e) {
            future = new AsyncResult<String>("error");
        }
        return future;
    }

}
