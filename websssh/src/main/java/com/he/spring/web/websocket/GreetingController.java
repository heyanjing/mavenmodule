//package com.he.spring.web.websocket;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
///**
// * Created by heyanjing on 2017/11/30 14:05.
// */
//@Controller
//public class GreetingController {
//    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
//    @Autowired
//    private SimpMessagingTemplate template;
//
//    @GetMapping("/websocket")
//    public String websocket() {
//        return "/websocket/websocket";
//    }
//
//
//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(HelloMessage message) throws Exception {
//            log.info("greeting");
////        for (int i = 0; i < 10; i++) {
////            Thread.sleep(1000); // simulated delay
////            template.convertAndSend("/topic/greetings", new Greeting("the number is" + i));
////        }
////        Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello, " + message.getName() + "!");
//    }
//
//}
