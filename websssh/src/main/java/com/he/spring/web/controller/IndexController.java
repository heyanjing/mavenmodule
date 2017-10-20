package com.he.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public  String index(){
        return  "/index";
    }
}
