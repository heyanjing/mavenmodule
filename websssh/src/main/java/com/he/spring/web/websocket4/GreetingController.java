package com.he.spring.web.websocket4;

import com.he.maven.module.utils.Randoms;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {



    @GetMapping("/websocket4")
    public String websocket(Model model, HttpServletRequest request) {
        model.addAttribute("sessionId", Randoms.getInt(10) % 2);
        return "/websocket/websocket4";
    }
}
