package com.chan.spring.bean.annotation.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void add() {
        System.out.println("添加用户信息");
    }
}
