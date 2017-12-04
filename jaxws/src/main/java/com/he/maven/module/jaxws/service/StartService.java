package com.he.maven.module.jaxws.service;

import javax.xml.ws.Endpoint;

/**
 * Created by heyanjing on 2017/12/4 16:48.
 */
public class StartService {
    public static void main(String[] args) {
        IService service = new ServiceImpl();
        Endpoint.publish("http://localhost:9089/service", service);
    }
}
