package com.he.spring.web.webservice.client;

import com.he.spring.util.Springs;
import com.he.spring.web.webservice.service.IService;
import com.he.spring.web.webservice.service.ISimpleService;
import com.he.spring.web.webservice.service.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by heyanjing on 2017/12/5 9:20.
 */
@Controller
public class SpringWsClient {
    private static final Logger log = LoggerFactory.getLogger(SpringWsClient.class);
    @Autowired
    private IService serviceImpl1;
    @Autowired
    private IService serviceImpl2;
    @Autowired
    private IService serviceImpl11;
    @Autowired
    private IService serviceImpl22;
    @Autowired
    private ISimpleService simpleClient1;
    @Autowired
    private ISimpleService simpleClient11;


    @RequestMapping("/spring/ws/client")
    @ResponseBody
    public Person getPerson() {
//        基于simple方式
//        ISimpleService simpleClient1 = Springs.getBean("simpleClient1", ISimpleService.class);
        Person xx1 = simpleClient1.getPerson("xx1");
        log.info("{}",xx1);
//        ISimpleService simpleClient11 = Springs.getBean("simpleClient11", ISimpleService.class);
        Person xx11 = simpleClient11.getPerson("xx11");
        log.info("{}",xx11);

//      基于jaxws方式
        Person person1 = serviceImpl1.getPerson("何彦静1");
        log.info("{}",person1);
        Person person2 = serviceImpl2.getPerson("何彦静2");
        log.info("{}",person2);
        Person person11 = serviceImpl11.getPerson("何彦静11");
        log.info("{}",person11);
        Person person22 = serviceImpl22.getPerson("何彦静22");
        log.info("{}",person22);
        return  person22;
    }

}
