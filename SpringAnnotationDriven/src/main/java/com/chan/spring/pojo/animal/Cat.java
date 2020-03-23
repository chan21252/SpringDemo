package com.chan.spring.pojo.animal;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Chan
 * @since 2020/3/23
 */
public class Cat implements InitializingBean, DisposableBean {
    private String name;

    public Cat() {
        System.out.println("构造Cat");
    }

    public Cat(String name) {
        System.out.println("构造Cat");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("设置cat name");
        this.name = name;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat.InitializingBean--->afterPropertiesSet Cat");
    }

    public void destroy() throws Exception {
        System.out.println("Cat.DisposableBean--->destroy");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Cat---->PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Cat---->PreDestroy");
    }

    private void init() {
        System.out.println("Cat--->init");
    }

    private void destroy2() {
        System.out.println("Cat--->destroy2");
    }
}
