package com.he.spring.web.websocket3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by heyanjing on 2017/12/1 10:22.
 */
@Controller
public class TestController {


    @GetMapping("/websocket3")
    public String websocket() {
        return "/websocket/websocket3";
    }
}
