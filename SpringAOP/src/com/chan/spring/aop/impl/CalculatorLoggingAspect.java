package com.chan.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class CalculatorLoggingAspect {

    @Before("execution(public int com.chan.spring.aop.impl.CalculatorImp.*(int, int))")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println(methodName + " begins with" + args);
    }

    /**
     * 后置通知，在方法执行之后执行，无论是否发生异常
     * @param joinPoint 连接点
     */
    @After("execution(public int com.chan.spring.aop.impl.CalculatorImp.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " ends");
    }

    /**
     * 后置返回通知，方法正常返回之后执行
     * @param joinPoint 连接点
     * @param result 返回值
     */
    @AfterReturning(value = "execution(public int com.chan.spring.aop.impl.CalculatorImp.*(..))",
    returning = "result")
    public void returnAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " ends with " + result);
    }

    @AfterThrowing(value = "execution(public int com.chan.spring.aop.impl.CalculatorImp.*(..))",
            throwing = "ex")
    public void throwingAdvice(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " occurs exception " + ex);
    }
}
