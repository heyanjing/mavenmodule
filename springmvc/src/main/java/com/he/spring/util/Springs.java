package com.he.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by heyanjing on 2017/11/15 11:22.
 */
public class Springs implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public static  <T>  T getBean(String var1, Class<T> var2){
       return  applicationContext.getBean(var1,var2);
    }

}
