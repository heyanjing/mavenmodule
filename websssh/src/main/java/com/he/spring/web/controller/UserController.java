package com.he.spring.web.controller;

import com.he.maven.module.utils.Dates;
import com.he.spring.entity.User;
import com.he.spring.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    private Integer count = 1;

    @RequestMapping("/save")
    @ResponseBody
    public User save() {
        User p = new User("name" + Dates.newDateString("yyyy-MM-dd_HH:mm:ss.SSS"), count++, Dates.newDate());
        return this.userService.save(p);
    }

    @RequestMapping("/findAllx")
    @ResponseBody
    public List<User> findAllx() {
        return this.userService.findAllx();
    }
}
