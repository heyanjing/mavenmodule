package com.he.spring.task.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/12/11 16:17.
 */
@Component
public class ScheduleDemo {

    public final static long ONE_DAY = 24 * 60 * 60 * 1000;
    public final static long ONE_HOUR = 60 * 60 * 1000;

    @Scheduled(fixedRate = ONE_DAY)
    public void scheduledTask() {
        System.out.println(" 我是一个每隔一天就会执行一次的调度任务");
    }

    @Scheduled(fixedDelay = ONE_HOUR)
    public void scheduleTask2() {
        System.out.println(" 我是一个执行完后，隔一小时就会执行的任务");
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void doSomething() {
        // something that should execute periodically
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void ScheduledTask3() {
        System.out.println(" 我是一个每隔一分钟就就会执行的任务");
    }
}
