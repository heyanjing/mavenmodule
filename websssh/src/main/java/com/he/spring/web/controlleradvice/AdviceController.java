package com.he.spring.web.controlleradvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Created by heyanjing on 2017/11/16 13:56.
 */
@ControllerAdvice
public class AdviceController {
    private static final Logger log = LoggerFactory.getLogger(AdviceController.class);

    //region Description // MEINFO:2017/11/16 14:19 这两个不常和@ControllerAdvice组合使用
    @ModelAttribute
    public AdviceBean newUser() {
        log.warn("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        return new AdviceBean("heyanjing");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        log.warn("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }
    //endregion

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String processUnauthenticatedException(NativeWebRequest request, Throwable e) {
        log.warn("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");
        log.error("{}",request);
        log.error("{}",e);
        return "/error/500"; //返回一个逻辑视图名
    }
}
