package com.chan.spring.aop.impl;

import org.aspectj.lang.JoinPoint;

/**
 * 本切面用XML文件配置
 */
public class HelloAspect {

    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("欢迎！");
    }

    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("再见！");
    }
}
