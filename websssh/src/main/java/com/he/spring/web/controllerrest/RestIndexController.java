package com.he.spring.web.controllerrest;

import com.he.maven.module.utils.bean.Result;
import com.he.maven.module.utils.bean.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@Controller
@RequestMapping("/rest/index")
public class RestIndexController {
    private static final Logger log = LoggerFactory.getLogger(RestIndexController.class);

    @GetMapping(value = {"","/"})
    public String index(){
        return "/rest/rest";
    }

    @RequestMapping("/result")
    @ResponseBody
    public Result result(){
        return Results.failure(1);
    }

}
