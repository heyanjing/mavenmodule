package com.he.maven.module.jms.simple2.receiver;

import com.he.maven.module.jms.simple2.TestBean;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * Created by heyanjing on 2017/12/6 16:59.
 */
public class ReceiveMQ {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session = null;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination = null;
        // 消费者，消息接收者
        //MessageConsumer consumer = null;
        connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.70.110:61616");
        try {
            //通过工厂创建链接
            connection = connectionFactory.createConnection();
            //启动链接
            connection.start();
            //创建会话
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            //消息目的地
            destination = session.createQueue("test-queue");
            //消息消费者
            MessageConsumer consumer = session.createConsumer(destination);
            //同步方式接受信息,如果还没有获取到则会阻塞直到接收到信息
        /*Message messages = consumer.receive();
        TestBean  value  =(TestBean)((ObjectMessage)messages).getObject();
                 String name = value.getName();*/
            consumer.setMessageListener(new MessageListener(){
                @Override
                public void onMessage(Message message){
                    try {
                        TestBean tbean =(TestBean)((ObjectMessage)message).getObject();
                        System.out.println("tbean: "+tbean);
                        if(null != message) {
                            System.out.println("收到信息1： "+tbean.getName());
                        }
                    } catch (JMSException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
