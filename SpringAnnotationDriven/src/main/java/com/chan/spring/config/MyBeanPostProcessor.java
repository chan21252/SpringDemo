package com.chan.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Chan
 * @since 2020/3/23
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        System.out.println(bean.getClass().getName() + "--->postProcessBeforeInitialization");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println(bean.getClass().getName() + "--->postProcessAfterInitialization");
        return bean;
    }
}
