package com.he.spring.web.controller;

import com.he.spring.web.aop.test.Ba;
import com.he.spring.web.aop.test.Interface.IA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@Controller
public class IndexController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private IA a1;
    @Autowired
    private IA a2;
    @Autowired
    private Ba ba;

//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private HttpServletResponse response;



    @RequestMapping("/")
    public String index() {
        log.info("{}",super.request);//Current HttpServletRequest
        log.info("{}",super.response);//Current HttpServletResponse
        return "/index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public void test() {
        this.jdkOrGglib();
    }

    /**
     * 测试aop的动态代理使用的是 jdk 还是cglib
     */
    private void jdkOrGglib() {

        //region Description
      /*
         <aop:aspectj-autoproxy /> // METIP: 2017/10/26 11:15 重要提醒
         默认情况:注入的是接口则使用jdk代理,
                     类则使用cglib

        2017-10-26 11:08:35.140 [http-apr-8080-exec-8] ERROR com.he.spring.web.controller.IndexController - class com.sun.proxy.$Proxy61 // MEINFO:2017/10/26 11:10 jdk代理
        2017-10-26 11:08:35.158 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - before前置通知
        2017-10-26 11:08:35.159 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.A1 - A1---say
        2017-10-26 11:08:35.229 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - after后置通知
        2017-10-26 11:08:35.245 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - afterReturning返回通知
        2017-10-26 11:08:35.246 [http-apr-8080-exec-8] ERROR com.he.spring.web.controller.IndexController - class com.sun.proxy.$Proxy61 // MEINFO:2017/10/26 11:10 jdk代理
        2017-10-26 11:08:35.246 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - before前置通知
        2017-10-26 11:08:35.246 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.A2 - A2---say
        2017-10-26 11:08:35.246 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - after后置通知
        2017-10-26 11:08:35.246 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - afterReturning返回通知
        2017-10-26 11:08:35.246 [http-apr-8080-exec-8] ERROR com.he.spring.web.controller.IndexController - class com.he.spring.web.aop.test.Ba$$EnhancerBySpringCGLIB$$20cb544e // MEINFO:2017/10/26 11:10 cglb代理
        2017-10-26 11:08:35.247 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - before前置通知
        2017-10-26 11:08:35.281 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.Ba - Ba---say
        2017-10-26 11:08:35.281 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - after后置通知
        2017-10-26 11:08:35.281 [http-apr-8080-exec-8] WARN  com.he.spring.web.aop.test.aspect.TestAspect - afterReturning返回通知

        <aop:aspectj-autoproxy  proxy-target-class="true"/>// METIP: 2017/10/26 11:15 重要提醒
        指定使用cglib动态代理a

        2017-10-26 11:17:21.077 [http-apr-8080-exec-3] ERROR com.he.spring.web.controller.IndexController - class com.he.spring.web.aop.test.A1$$EnhancerBySpringCGLIB$$7f9c3fca// MEINFO:2017/10/26 11:10 cglb代理
        2017-10-26 11:17:21.112 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - before前置通知
        2017-10-26 11:17:21.498 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.A1 - A1---say
        2017-10-26 11:17:21.505 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - after后置通知
        2017-10-26 11:17:21.507 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - afterReturning返回通知
        2017-10-26 11:17:21.507 [http-apr-8080-exec-3] ERROR com.he.spring.web.controller.IndexController - class com.he.spring.web.aop.test.A2$$EnhancerBySpringCGLIB$$9337c86d// MEINFO:2017/10/26 11:10 cglb代理
        2017-10-26 11:17:21.507 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - before前置通知
        2017-10-26 11:17:21.562 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.A2 - A2---say
        2017-10-26 11:17:21.562 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - after后置通知
        2017-10-26 11:17:21.562 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - afterReturning返回通知
        2017-10-26 11:17:21.563 [http-apr-8080-exec-3] ERROR com.he.spring.web.controller.IndexController - class com.he.spring.web.aop.test.Ba$$EnhancerBySpringCGLIB$$8c9b6a17// MEINFO:2017/10/26 11:10 cglb代理
        2017-10-26 11:17:21.563 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - before前置通知
        2017-10-26 11:17:21.593 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.Ba - Ba---say
        2017-10-26 11:17:21.593 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - after后置通知
        2017-10-26 11:17:21.593 [http-apr-8080-exec-3] WARN  com.he.spring.web.aop.test.aspect.TestAspect - afterReturning返回通知
                */
        //endregion

        log.error("{}", this.a1.getClass());
        this.a1.say();
        log.error("{}", this.a2.getClass());
        this.a2.say();
        log.error("{}", this.ba.getClass());
        this.ba.say();


    }
}
