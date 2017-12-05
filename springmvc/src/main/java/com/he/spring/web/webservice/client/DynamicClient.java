package com.he.spring.web.webservice.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/12/5 8:57.
 * 方案三：通用动态代理客户端
 * 它不仅用于调用 JAX-WS 方式发布的 WS，也用于使用 simple 方式发布的 WS，更加智能了。
 */
public class DynamicClient {
    private static final Logger log = LoggerFactory.getLogger(DynamicClient.class);

    public static void main(String[] args) {
        DynamicClientFactory factory = DynamicClientFactory.newInstance();
        Client client1 = factory.createClient("http://localhost:8080/ws/ws1?wsdl");
        Client client2 = factory.createClient("http://localhost:8080/ws/ws2?wsdl");
        Client client3 = factory.createClient("http://localhost:8080/ws/simple?wsdl");

        try {
            Object[] results1 = client1.invoke("getPerson", "何彦静1");
            log.info("{}", results1[0]);
            Object[] results2 = client2.invoke("getPerson", "何彦静2");
            log.info("{}", results2[0]);
            Object[] results3 = client3.invoke("getPerson", "何彦静3");
            log.info("{}", results3[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
