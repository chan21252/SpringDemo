package com.chan.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("前置处理器：" + beanName);
        if ("car2".equals(beanName)) {
            System.out.println("这是car2");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器：" + beanName);
        Car car = new Car();
        car.setBrand("保时捷");
        return car;
    }
}
