package com.he.spring.web.websocket2;

import com.he.spring.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by heyanjing on 2017/12/1 9:27.
 */
@Controller
public class WSController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(WSController.class);
    //websocket服务层调用类
    @Autowired
    private WSService wsService;

    @GetMapping("/websocket2")
    public String websocket() {
        return "/websocket/websocket2";
    }

    //请求入口
    @RequestMapping(value = "/TestWS", method = RequestMethod.GET)
    @ResponseBody
    public String TestWS(@RequestParam(value = "userId", required = true) Long userId, @RequestParam(value = "message", required = true) String message) {
        log.debug("收到发送请求，向用户{}的消息：{}", userId, message);
        if (wsService.sendToAllTerminal(userId, message)) {
            return "发送成功";
        } else {
            return "发送失败";
        }
    }
}
