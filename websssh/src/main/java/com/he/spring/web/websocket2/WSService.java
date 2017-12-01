package com.he.spring.web.websocket2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by heyanjing on 2017/12/1 9:23.
 */
@Service
public class WSService {
    private Logger log = LoggerFactory.getLogger(WSService.class);
    //声明websocket连接类
    private WS websocketDemo = new WS();

    /**
     * @param @param  userId 用户id
     * @param @param  message 消息
     * @param @return 发送成功返回true，否则返回false
     * @Title: sendToAllTerminal
     * @Description: 调用websocket类给用户下的所有终端发送消息
     */
    public Boolean sendToAllTerminal(Long userId, String message) {
        log.debug("向用户{}的消息：{}", userId, message);
        if (websocketDemo.sendMessageToUser(userId, message)) {
            return true;
        } else {
            return false;
        }
    }
}

