package com.chan.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 1)
@Component
@Aspect
public class ValidationAspect {

    @Before("execution(public int com.chan.spring.aop.impl.CalculatorImp.*(int, int))")
    public void validate(JoinPoint joinPoint) {
        System.out.println("参数检查");
    }
}
