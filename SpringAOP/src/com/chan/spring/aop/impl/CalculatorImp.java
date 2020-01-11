package com.chan.spring.aop.impl;

import org.springframework.stereotype.Component;

/**
 * 计算器实现类
 */
@Component
public class CalculatorImp implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int multi(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
