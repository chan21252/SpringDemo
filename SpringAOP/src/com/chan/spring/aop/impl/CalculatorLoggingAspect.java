package com.chan.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(value = 2)
@Component
@Aspect
public class CalculatorLoggingAspect {

    /**
     * 切点表达式
     */
    @Pointcut(value = "execution(public int com.chan.spring.aop.impl.CalculatorImp.*(int, int))")
    public void pointCutExpression() {
    }

    @Before("pointCutExpression()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println(methodName + " begins with" + args);
    }

    /**
     * 后置通知，在方法执行之后执行，无论是否发生异常
     *
     * @param joinPoint 连接点
     */
    @After("pointCutExpression()")
    public void afterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " ends");
    }

    /**
     * 后置返回通知，方法正常返回之后执行
     * @param joinPoint 连接点
     * @param result 返回值
     */
    @AfterReturning(value = "pointCutExpression()",
            returning = "result")
    public void returnAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " ends with " + result);
    }

    @AfterThrowing(value = "pointCutExpression()",
            throwing = "ex")
    public void throwingAdvice(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " occurs exception " + ex.getMessage());
    }

    @Around(value = "pointCutExpression()",
            argNames = "pjp")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object result;
        String methodName = pjp.getSignature().getName();
        try {
            System.out.println(methodName + "方法前置通知");
            //执行方法
            result = pjp.proceed();
            System.out.println(methodName + "返回通知");
        } catch (Throwable e) {
            System.out.println(methodName + "异常通知：" + e.getMessage());
            throw new RuntimeException(e);
        }

        System.out.println(methodName + "后置通知");
        return result;
    }
}
