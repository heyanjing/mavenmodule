package com.he.maven.module.jms.simple2.send;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by heyanjing on 2017/12/7 9:10.
 */
public class Send1 {
    public static void main(String[] args) throws Exception {
        //创建一个JMS connection factory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://127.0.0.1:61616");
        //通过connection factory来创建JMS connection
        Connection connection = connectionFactory.createConnection();
        //通过connection创建JMS session
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        //创建JMS destination
        Destination destination = session.createTopic("PersistenceTopic");
        //创建JMS producer
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //启动JMS connection
        connection.start();
        for(int i = 0;i < 5;i++){
            TextMessage message = session.createTextMessage("message"+i);
            //发送message
            producer.send(message);
        }
        //关闭所有的JMS资源
        session.close();
        connection.close();
    }

}
