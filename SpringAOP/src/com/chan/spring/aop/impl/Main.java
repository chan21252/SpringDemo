package com.chan.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/chan/spring/aop/conf/applicationContext.xml");
        Calculator calculatorImpl = (Calculator) ctx.getBean("calculatorImp");
        int result = calculatorImpl.add(2, 3);
        int result2 = calculatorImpl.div(25, 0);
        System.out.println(result);
        System.out.println(result2);
    }
}