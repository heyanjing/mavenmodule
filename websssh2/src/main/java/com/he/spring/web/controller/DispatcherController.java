package com.he.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by heyanjing on 2017/11/14 14:26.
 */
@Controller
public class DispatcherController {

    @GetMapping(value="/")
    public String index() {
        return "/index";
    }
}
