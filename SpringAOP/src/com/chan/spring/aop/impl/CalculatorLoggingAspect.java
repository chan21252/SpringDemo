package com.chan.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class CalculatorLoggingAspect {

    @Before("execution(public int com.chan.spring.aop.impl.CalculatorImp.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println(methodName + " begins with" + args);
    }
}
