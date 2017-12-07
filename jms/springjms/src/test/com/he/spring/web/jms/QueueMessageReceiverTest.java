package com.he.spring.web.jms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by heyanjing on 2017/12/6 14:54.
 *
 * 同步接受下队列消息
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base-jms.xml"})
public class QueueMessageReceiverTest {
    private static final Logger log = LoggerFactory.getLogger(QueueMessageReceiverTest.class);

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination queueDestination;
    @Autowired
    private Destination topicDestination;


    @Test
    public void receiveMqMessage() {
//        receive(queueDestination);
    }

    /**
     * 接受消息
     */
    public void receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);//// MEINFO:2017/12/6 14:58 同步方式接受消息 在这里一直阻塞起，知道收到消息或者达到配置的超时时间(单位ms)
        try {
            log.info("从队列" + destination.toString() + "收到了消息：\t" + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
