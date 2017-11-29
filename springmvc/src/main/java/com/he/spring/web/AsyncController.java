package com.he.spring.web;

import com.he.spring.async.LongTimeAsyncCallService;
import com.he.spring.bean.User3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * Created by heyanjing on 2017/11/23 10:40.
 */
@Controller
@RequestMapping("/async")
public class AsyncController {
    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    private LongTimeAsyncCallService longTimeAsyncCallService = new LongTimeAsyncCallService();

    /**
     * 第一种方式
     *
     * 使用了spring-web中配置的async-support
     */
    @GetMapping(value = {"/callable/", "/callable"})
    @ResponseBody
    public Callable<User3> callable(@RequestParam(value = "handled", defaultValue = "1") Integer handled) {

        return () -> {
            Thread.sleep(2000 * handled);
            return new User3("何彦静x", 32, new Date(), LocalDate.now(), LocalDateTime.now());
        };
    }

    /** 第二种方式
     *
     * 没有使用到spring-web中的async-support
     */
    @GetMapping(value = {"/deferredResult/", "/deferredResult"})
    @ResponseBody
    public DeferredResult<User3> deferredResult(@RequestParam(value = "handled", defaultValue = "1") Integer handled) {
        DeferredResult<User3> result = new DeferredResult<User3>();
        try {
            Thread.sleep(2000 * handled);
            result.setResult(new User3("何彦静xx", 32, new Date(), LocalDate.now(), LocalDateTime.now()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = {"/deferredResult2/", "/deferredResult2"})
    @ResponseBody
    public DeferredResult<User3> asyncTask() {
        DeferredResult<User3> deferredResult = new DeferredResult<User3>(2000l);
        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());

        CompletableFuture.supplyAsync(longTimeAsyncCallService::execute).whenCompleteAsync((result, throwable) ->   deferredResult.setResult(result));


//        longTimeAsyncCallService.makeRemoteCallAndUnknownWhenFinish(new LongTermTaskCallback() {
//            @Override
//            public void callback(Object result) {
//                System.out.println("异步调用执行完成, thread id is : " + Thread.currentThread().getId());
//                deferredResult.setResult(new User3("何彦静xx", 32, new Date(), LocalDate.now(), LocalDateTime.now()));
//            }
//        });
//        deferredResult.onTimeout(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("异步调用执行超时！thread id is : " + Thread.currentThread().getId());
//                deferredResult.setResult(new User3("何彦静--超时", 32, new Date(), LocalDate.now(), LocalDateTime.now()));
//            }
//        });
        return deferredResult;
    }

    /**
     * 第三种方式
     * 没有使用到spring-web中的async-support
     */
    @GetMapping(value = {"/webasynctask/", "/webasynctask"})
    @ResponseBody
    public WebAsyncTask webasynctask(){
        System.out.println("/longtimetask被调用 thread id is : " + Thread.currentThread().getId());
        Callable<User3> callable = new Callable<User3>() {
            public User3 call() throws Exception {
                Thread.sleep(3000); //假设是一些长时间任务
                System.out.println("执行成功 thread id is : " + Thread.currentThread().getId());
                return new User3("何彦静xx", 32, new Date(), LocalDate.now(), LocalDateTime.now());
            }
        };
        WebAsyncTask asyncTask = new WebAsyncTask(4000, callable);
        asyncTask.onTimeout(
                new Callable<User3>() {
                    public User3 call() throws Exception {
                        ModelAndView mav = new ModelAndView("longtimetask");
                        mav.addObject("result", "执行超时");
                        System.out.println("执行超时 thread id is ：" + Thread.currentThread().getId());
                        return new User3("何彦静--超时", 32, new Date(), LocalDate.now(), LocalDateTime.now());
                    }
                }
        );
        return asyncTask;
//        return new WebAsyncTask(callable);
    }
}
