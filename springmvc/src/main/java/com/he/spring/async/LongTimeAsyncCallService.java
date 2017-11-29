package com.he.spring.async;

import com.he.spring.bean.User3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by heyanjing on 2017/11/27 16:59.
 */
public class LongTimeAsyncCallService {
    private static final Logger log = LoggerFactory.getLogger(LongTimeAsyncCallService.class);
    private final int CorePoolSize = 4;
    private final int NeedSeconds = 3;
    private Random random = new Random();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CorePoolSize);

    public void makeRemoteCallAndUnknownWhenFinish(LongTermTaskCallback callback){
        System.out.println("完成此任务需要 : " + NeedSeconds + " 秒");
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                callback.callback("长时间异步调用完成.");
            }
        }, NeedSeconds, TimeUnit.SECONDS);
    }

    public User3 execute() {
        try {
            Thread.sleep(5000);
            log.info("Slow task executed");
            return new User3("何彦静xx", 32, new Date(), LocalDate.now(), LocalDateTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
