package com.he.spring.web.websocket4;

import com.he.maven.module.utils.Randoms;
import com.he.spring.web.websocket.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by heyanjing on 2017/12/1 11:05.
 * 这个类里面注入了SimpMessagingTemplete对象，后面动态发送消息时需要这个对象。
 * 第一个方法，表示服务器端可以接收客户端通过主题"/app/hello"发送过来的消息，客户端需要在主题"/topic/hello"上监听并接收服务器发回的消息。
 * 第二个方法道理相同，只是注意这里用的是@SendToUser注解，这就是发送给单一客户端的标志。本例中，客户端接收一对一消息的主题应该是"/user/"+userId+"/message"，这里的用户id可以是一个普通字符串，只要每个客户端都使用自己的id并且服务器端知道每个用户的id就行了。
 * 发送消息使用SimpMessagingTemplete类的convertAndSend("/topic/hello", greeting); //广播，和convertAndSendToUser(userId, "/message", userMessage); //一对一发送给特定用户。
 */
@RestController
public class GreetingWS {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;
    @Autowired
    private  SimpMessagingTemplate template;


//    @GetMapping("/websocket4")
//    public String websocket(Model model, HttpServletRequest request) {
//        model.addAttribute("sessionId", Randoms.getInt(10) % 2);
//        return "/websocket/websocket4";
//    }

    /**
     * 表示服务端可以接收客户端通过主题“/app/hello”发送过来的消息，客户端需要在主题"/topic/hello"上监听并接收服务端发回的消息
     *
     * @param topic
     * @param headers
     */
    @MessageMapping("/hello") //"/hello"为WebSocketConfig类中registerStompEndpoints()方法配置的
    @SendTo("/topic/greetings")
    public Greeting greeting(@Header("atytopic") String topic,String name, @Headers Map<String, Object> headers) {
        System.out.println("connected successfully....");
        System.out.println(topic);
        System.out.println(name);
        System.out.println(headers);
       return  new Greeting("Hello, " +topic+ "!");
    }

    /**
     * 这里用的是@SendToUser，这就是发送给单一客户端的标志。本例中，
     * 客户端接收一对一消息的主题应该是“/user/” + 用户Id + “/message” ,这里的用户id可以是一个普通的字符串，只要每个用户端都使用自己的id并且服务端知道每个用户的id就行。
     *
     * @return
     */
    @MessageMapping("/message")
    @SendToUser("/message")
    public Greeting handleSubscribe(String msg) {
        return new Greeting(msg);
    }

    @RequestMapping(path = "/send", method = RequestMethod.GET)
    public Greeting send() {
        Greeting greeting = new Greeting("多用户消息");
        template.convertAndSend("/topic/greetings",greeting);
        return greeting;
    }
    @RequestMapping(path = "/send2", method = RequestMethod.GET)
    public Greeting send2() {
        Greeting greeting = new Greeting("单用户消息");
        template.convertAndSendToUser(Randoms.getInt(10) % 2+"", "/message",greeting);
        return greeting;
    }

}
