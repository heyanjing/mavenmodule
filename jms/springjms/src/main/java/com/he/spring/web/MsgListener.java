package com.he.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by heyanjing on 2017/12/6 11:35.
 */
public class MsgListener implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(MsgListener.class);
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            log.warn("监听到了文本消息：\t" + tm.getText());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
