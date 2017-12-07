package com.he.spring.web.jms1;

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
import java.io.Serializable;

/**
 * Created by heyanjing on 2017/12/6 14:47.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base-jms1.xml"})
public class JMSTest {
    private static final Logger log = LoggerFactory.getLogger(JMSTest.class);
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination destination;
    @Autowired
    private Destination destinationTopic;


    @Test
    public void send() throws Exception {
//        sendTextMessage(destination, "发送Queue消息");
        sendTextMessage(destinationTopic,"发送Topic消息");


//        sendObjectMessage(destination, new TestBean(22, "何彦静"));//传递json对象有问题


    }

    @Test
    public void receive() {
//        Object msg = jmsTemplate.receiveAndConvert(destination);
        Object msg = jmsTemplate.receiveAndConvert(destinationTopic);

        log.warn("{}",msg);
    }


    public void sendTextMessage(Destination destination, final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
        log.info(message);
    }

    public void sendObjectMessage(Destination destination, Serializable object) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(object);
            }
        });
        log.info("{}", object);
    }
}