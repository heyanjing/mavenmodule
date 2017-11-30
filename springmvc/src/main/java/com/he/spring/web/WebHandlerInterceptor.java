package com.he.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by heyanjing on 2017/11/29 10:43.
 *
 * 继承HandlerInterceptorAdapter更好些
 */
public class WebHandlerInterceptor extends HandlerInterceptorAdapter/* implements HandlerInterceptor*/ {
    private static final Logger log = LoggerFactory.getLogger(WebHandlerInterceptor.class);
    //执行前调用 当此方法返回 true 时，hadler 执行链会继续执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("preHandle");
        //如果第一个拦截器的这个方法校验没通过，应该返回一个固定的视图httpServletResponse.sendRedirect();
        return true;
    }

    //执行后调用
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    //整一个请求完成后调用
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("afterCompletion");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("afterConcurrentHandlingStarted");
    }
}
