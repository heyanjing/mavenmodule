package com.he.spring.web.webservice.client;

import com.he.spring.web.webservice.service.IService;
import com.he.spring.web.webservice.service.Person;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/12/5 8:51.
 * 方案一：静态代理客户端
 */
public class JaxWsClient {
    private static final Logger log = LoggerFactory.getLogger(JaxWsClient.class);

    public static void main(String[] args) {
//        jax-ws方式
        JaxWsProxyFactoryBean factory1 = new JaxWsProxyFactoryBean();
        factory1.setAddress("http://localhost:8080/ws/ws1");
        factory1.setServiceClass(IService.class);
        IService iService1 = factory1.create(IService.class);
        Person person = iService1.getPerson("何彦静1");
        log.info("{}", person);

        JaxWsProxyFactoryBean factory2 = new JaxWsProxyFactoryBean();
        factory2.setAddress("http://localhost:8080/ws/ws2");
        factory2.setServiceClass(IService.class);
        IService iService2 = factory2.create(IService.class);
        Person person2 = iService2.getPerson("何彦静2");
        log.info("{}", person2);

//simple方式
        ClientProxyFactoryBean factory3 = new ClientProxyFactoryBean();
        factory3.setAddress("http://localhost:8080/ws/ws3");
        factory3.setServiceClass(IService.class);
        IService iService3 = factory3.create(IService.class);
        Person person3 = iService3.getPerson("何彦静3");
        log.info("{}", person3);
    }
}
