package com.he.maven.module.exhandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by heyanjing on 2017/10/27 14:57.
 */
public class SMExceptionResolver extends SimpleMappingExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(SMExceptionResolver.class);

    @Override
    protected void prepareResponse(Exception ex, HttpServletResponse response) {
        log.error("prepareResponse");
        log.error(ex.getMessage());
        super.prepareResponse(ex, response);
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.error("doResolveException");
        log.error(ex.getMessage());
        log.error("xxxxxxxxxxxxxxxxxxxxx"+handler);
        return super.doResolveException(request, response, handler, ex);
    }
}
