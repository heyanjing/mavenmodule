package com.he.maven.module.jms.simple2.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

/**
 * Created by heyanjing on 2017/12/7 9:10.
 */
public class Receive1 {
    public static void main(String[] args) throws Exception {
        // 创建一个JMS connection factory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");
        // 通过connection factory来创建JMS connection
        Connection connection = connectionFactory.createConnection();
        // 设置一个标记id
        connection.setClientID("TT");
        // 启动JMS connection
        connection.start();
        // 通过connection创建JMS session
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        // 创建JMS destination
        Topic destination = session.createTopic("PersistenceTopic");
        // 创建JMS consumer 按照目的地和唯一clientId标示。
        // TopicSubscriber是MessageConsumer的子接口
        TopicSubscriber ts = session.createDurableSubscriber(destination, "TT");
        // 设置监听
        ts.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                message = (TextMessage) message;
                try {
                    String value = ((TextMessage) message).getText();
                    System.out.println("value2: " + value);
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
}
