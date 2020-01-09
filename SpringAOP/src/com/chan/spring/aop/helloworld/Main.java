package com.chan.spring.aop.helloworld;

public class Main {
    public static void main(String[] args) {
        //目标对象
        Calculator target = new CalculatorImp();

        //目标对象获取代理对象
        Calculator targetProxy = new CalculatorLoggingProxy(target).getLoggingProxy();

        System.out.println(targetProxy.add(1, 2));
    }
}
