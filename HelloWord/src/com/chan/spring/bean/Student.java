package com.chan.spring.bean;

/**
 * Student Bean
 *
 * @author Chan
 */
public class Student {
    private String name;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("我是" + name);
    }
}
