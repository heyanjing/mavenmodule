package com.he.spring.web.ex;

import com.google.common.base.Throwables;
import com.he.maven.module.utils.Webs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by heyanjing on 2017/10/27 15:53.
 */
public class GlobalExceptionHandlerBase {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerBase.class);
    protected static final Logger logger = null;
    protected static final String DEFAULT_ERROR_MESSAGE = "系统忙，请稍后再试";

    protected ModelAndView handleError(HttpServletRequest req, HttpServletResponse rsp, Exception e, String viewName, HttpStatus status) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        String errorMsg = DEFAULT_ERROR_MESSAGE;
        String errorStack = Throwables.getStackTraceAsString(e);

        log.error("Request: {} raised {}", req.getRequestURI(), errorStack);
        if (Webs.isAjaxRequest(req)) {
            return handleAjaxError(rsp, errorMsg, status);
        }
        return handleViewError(req.getRequestURL().toString(), errorStack, errorMsg, viewName);
    }

    protected ModelAndView handleViewError(String url, String errorStack, String errorMessage, String viewName) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", errorStack);
        mav.addObject("url", url);
        mav.addObject("message", errorMessage);
        mav.addObject("timestamp", new Date());
        mav.setViewName(viewName);
        return mav;
    }

    protected ModelAndView handleAjaxError(HttpServletResponse rsp, String errorMessage, HttpStatus status) throws IOException {
        rsp.setCharacterEncoding("UTF-8");
        rsp.setStatus(status.value());
        PrintWriter writer = rsp.getWriter();
        writer.write(errorMessage);
        writer.flush();
        return null;
    }
}
