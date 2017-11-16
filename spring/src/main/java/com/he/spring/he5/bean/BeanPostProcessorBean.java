package com.he.spring.he5.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by heyanjing on 2017/11/16 10:29.
 */
public class BeanPostProcessorBean implements BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(BeanPostProcessorBean.class);

    public BeanPostProcessorBean() {
        log.info("bean初始化");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        log.info("bean初始化之前执行");
        log.info("{}",o);
        log.info("{}",s);

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        log.info("bean初始化之后执行");
        log.info("{}",o);
        log.info("{}",s);
        return o;
    }
}
