package com.chan.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * MathCalculatorAspect
 *
 * @author Chan
 * @since 2020/3/26
 */
@Aspect
public class MathCalculatorAspect {

    @Pointcut("execution(public int com.chan.spring.aop.MathCalculator.*(..))")
    public void pointcut() {

    }

    @Before(value = "com.chan.spring.aop.MathCalculatorAspect.pointcut()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "开始执行，参数列表：" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "返回：" + result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "exception")
    public void logThrowing(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "异常：" + exception.getMessage());
    }

    @After("pointcut()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "执行结束");
    }
}
