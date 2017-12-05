package com.he.spring.web.webservice.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/12/5 8:54.
 * 方案二：动态代理客户端
 * 只能调用 JAX-WS 方式发布的 WS
 */
public class JaxWsDynamicClient {
    private static final Logger log = LoggerFactory.getLogger(JaxWsDynamicClient.class);

    public static void main(String[] args) {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client1 = factory.createClient("http://localhost:8080/ws/ws1?wsdl");
        Client client2 = factory.createClient("http://localhost:8080/ws/ws2?wsdl");
//        Client client3 = factory.createClient("http://localhost:8080/ws/ws3?wsdl");//启动报错

        try {
            Object[] results = client1.invoke("getPerson", "何彦静1");
            log.info("{}", results[0]);
            Object[] results2 = client2.invoke("getPerson", "何彦静2");
            log.info("{}", results2[0]);
//            Object[] results3 = client3.invoke("getPerson", "何彦静3");
//            log.info("{}", results3[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
