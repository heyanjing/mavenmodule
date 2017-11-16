package com.he.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by heyanjing on 2017/11/15 17:19.
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
}
