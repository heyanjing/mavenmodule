package com.he.spring.he5.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by heyanjing on 2017/11/16 10:32.
 */
public class BeanFactoryPostProcessorBean implements BeanFactoryPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(BeanFactoryPostProcessorBean.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("容器初始化后执行");
        BeanPostProcessorBean bean = configurableListableBeanFactory.getBean("beanPostProcessorBean", BeanPostProcessorBean.class);
        log.info("{}",bean);
    }
}
