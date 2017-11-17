package com.he.spring.he5.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * Created by heyanjing on 2017/11/17 14:43.
 */
@Component
public class ListenerBean implements ApplicationListener {
    private static final Logger log = LoggerFactory.getLogger(ListenerBean.class);
    @Override
    public void onApplicationEvent(ApplicationEvent e) {
        if(e instanceof ContextStartedEvent){
            log.warn("ContextStartedEvent");
        }else if (e instanceof ContextStartedEvent){
            log.warn("ContextStartedEvent");
        }else if (e instanceof ContextStoppedEvent){
            log.warn("ContextStoppedEvent");
        }else if (e instanceof ContextClosedEvent){
            log.warn("ContextClosedEvent");
        }else if (e instanceof ContextRefreshedEvent){
            log.warn("ContextRefreshedEvent");
        }else if (e instanceof RequestHandledEvent){
            log.warn("RequestHandledEvent");
        }
    }
}
