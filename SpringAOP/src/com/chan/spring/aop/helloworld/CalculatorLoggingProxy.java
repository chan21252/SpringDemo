package com.chan.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 计算器日志代理
 */
public class CalculatorLoggingProxy {
    /**
     * 要代理的对象
     */
    private Calculator target;

    /**
     * 构造器
     * @param target Calculator
     */
    public CalculatorLoggingProxy(Calculator target) {
        this.target = target;
    }

    /**
     * 创建代理对象
     * @return Calculator
     */
    public Calculator getLoggingProxy() {
        Calculator proxy = null;

        //代理对象由哪个类加载器加载
        ClassLoader loader = target.getClass().getClassLoader();

        //代理对象的要实现的接口
        Class<?>[] interfaces = new Class<?>[]{Calculator.class};

        //当调用代理对象方法时，需要执行的代码
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy 代理，在invoke方法中一般不会使用该对象，
             *              因为proxy调用任意方法都会先执行invoke，会死循环内存溢出
             * @param method 正在被执行的方法
             * @param args 执行方法所需要的参数数组
             * @return Object
             * @throws Throwable Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //日志
                System.out.println("-->正在执行" + methodName + "方法，参数是" + Arrays.asList(args));

                //执行目标方法
                Object result = method.invoke(target, args);

                //日志
                System.out.println("-->执行" + methodName + "方法结束，结果是" + result);
                return result;
            }
        };

        //创建动态代理对象
        proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, handler);
        return proxy;
    }
}
