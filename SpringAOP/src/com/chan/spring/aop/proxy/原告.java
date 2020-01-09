package com.chan.spring.aop.proxy;

/**
 * 原告类
 */
public class 原告 implements 诉讼{
    private String name;

    public 原告() {
    }

    public 原告(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void 起诉() {
        System.out.println(name + "起诉");
    }

    @Override
    public void 出庭() {
        System.out.println(name + "出庭");
    }

    @Override
    public void 撤诉() {
        System.out.println(name + "撤诉");
    }

    @Override
    public String toString() {
        return  getName();
    }
}
