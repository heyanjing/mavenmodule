package com.he.spring.web.task.dynamic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heyanjing on 2017/10/26 16:05.
 */
public class Main {
    public static void main(String[] args) {
        //region Description
        //quartz的多任务
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-base-task-quartz.xml");
        //endregion





        //region Description
        //quartz的动态任务
        /*ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-base-task-dynamic.xml");
        QuartzManager quartzManager = (QuartzManager) ctx.getBean("quartzManager");
        try {
            System.out.println("【系统启动】开始(每1秒输出一次 JobCustom)...");

            Thread.sleep(5000);
            System.out.println("【增加JobQuartz启动】开始(每1秒输出一次)...");
            quartzManager.addJob("test", "test", "test", "test", JobQuartz.class, "0/1 * * * * ?");

            Thread.sleep(5000);
            System.out.println("【修改JobQuartz时间】开始(每2秒输出一次)...");
            quartzManager.modifyJobTime("test", "test", "test", "test", "0/2 * * * * ?");

            Thread.sleep(10000);
            System.out.println("【移除JobQuartz定时】开始...");
            quartzManager.removeJob("test", "test", "test", "test");

            // 关掉任务调度容器
            // quartzManager.shutdownJobs();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //endregion
    }
}
