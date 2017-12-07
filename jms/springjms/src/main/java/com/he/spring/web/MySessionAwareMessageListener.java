package com.he.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by heyanjing on 2017/12/7 14:22.
 */
public class MySessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {
private static final Logger log = LoggerFactory.getLogger(MySessionAwareMessageListener.class);
    private Destination destination;
    @Override
    public void onMessage(TextMessage message, Session session) throws JMSException {
        log.warn("MySessionAwareMessageListener监听消息内容："+ message.getText());
//        MessageProducer messageProducer = session.createProducer(destination);
//        TextMessage replyMessage = session.createTextMessage("已收到消息："+ message.getJMSMessageID());
//        messageProducer.send(replyMessage);
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
