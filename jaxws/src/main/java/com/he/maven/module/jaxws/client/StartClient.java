package com.he.maven.module.jaxws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by heyanjing on 2017/12/4 16:51.
 */
public class StartClient {
    private static final Logger log = LoggerFactory.getLogger(StartClient.class);

    public static void main(String[] args) {
        //创建HelloWorldImplService对象
        ServiceImplService serviceImplService = new ServiceImplService();
        ServiceImpl serviceImplPort = serviceImplService.getServiceImplPort();
        Person person = serviceImplPort.getPerson("何彦静");
        log.info("{}", person);
    }
}
