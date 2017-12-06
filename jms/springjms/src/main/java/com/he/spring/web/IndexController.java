package com.he.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by heyanjing on 2017/11/23 10:40.
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);


    @GetMapping(value = {"","/"})
    public String helloWorld() {
        return "/index";
    }

}
