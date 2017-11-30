package com.he.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by heyanjing on 2017/11/23 10:40.
 *
 * 无效
 * 无效
 * 无效
 * 无效
 *
 */
public class ClassNameController extends AbstractController {
    private static final Logger log = LoggerFactory.getLogger(ClassNameController.class);

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "这个是ClassNameController");
        mv.setViewName("/index");
        return mv;
    }
}
