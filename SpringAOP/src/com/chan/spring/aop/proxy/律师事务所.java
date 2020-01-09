package com.chan.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 律师事务所
 */
public class 律师事务所 {
    private 诉讼 委托人;

    public 律师事务所(诉讼 委托人) {
        this.委托人 = 委托人;
    }

    public 诉讼 委派代理律师() {
        诉讼 律师 = null;

        //律师和委托人是都可以诉讼
        ClassLoader 委托人的诉求类型 = 委托人.getClass().getClassLoader();

        //律师要完成诉讼所有的职责
        Class<?>[] 律师职责 = {诉讼.class};

        //律师的工作流程
        InvocationHandler 工作流程 = new InvocationHandler() {
            /**
             * 开展业务
             * @param proxy 律师
             * @param method 诉讼行为
             * @param args 所需材料
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("律师代理委托人" + 委托人 + methodName);
                method.invoke(委托人, args);
                return 0;
            }
        };

        //给委托人找到一个代理律师
        律师 = (诉讼) Proxy.newProxyInstance(委托人的诉求类型, 律师职责, 工作流程);

        return 律师;
    }
}
