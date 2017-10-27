package com.he.maven.module.exhandle;

import com.he.maven.module.utils.Jsons;
import com.he.maven.module.utils.Servlets;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by heyanjing on 2017/10/27 15:20.
 */
public class GlobalExceptionHandlerCustom implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        ModelAndView mv=null;
        String url = Servlets.getRequestURL(request);
        String params = Jsons.toJson(request.getParameterMap());
        if(e instanceof  RuntimeException){
            mv=new ModelAndView("/error/500");
        }else if(e instanceof HttpRequestMethodNotSupportedException){
            mv=new ModelAndView("/error/404");
        }

        return mv;//注意：如果resolveException返回了ModelAndView，会优先显示返回值中的页面。如果，resolveException返回null，并且在web.xml中配置了error-page的500状态码对应的页面，则会显示该页面。

    }
}
