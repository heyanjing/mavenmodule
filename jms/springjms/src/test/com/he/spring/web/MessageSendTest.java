package com.he.spring.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by heyanjing on 2017/12/6 14:47.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base-jms.xml"})
public class MessageSendTest {
    private static final Logger log = LoggerFactory.getLogger(MessageSendTest.class);
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination queueDestination;
    @Autowired
    private Destination topicDestination;


    @Test
    public void send() throws Exception {
        sendMqMessage(queueDestination,"发送Queue消息");
        sendMqMessage(topicDestination,"发送Topic消息");
    }

    public void sendMqMessage(Destination destination, final String message) {
        if (null == destination) {
            destination = jmsTemplate.getDefaultDestination();
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
        log.info(message);
    }
}