package com.he.spring.web.controllerrest;

import com.he.maven.module.utils.bean.Result;
import com.he.maven.module.utils.bean.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@RestController
public class RestDataController {
    private static final Logger log = LoggerFactory.getLogger(RestDataController.class);

    @GetMapping("/rest/data")
    public String index(){
        return "/rest/rest";
    }

    @GetMapping("/rest/data/result")
    public Result result(){
        return Results.failure(1);
    }

}
