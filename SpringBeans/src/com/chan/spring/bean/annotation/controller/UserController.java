package com.chan.spring.bean.annotation.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    public void execute() {
        System.out.println("执行用户操作");
    }
}
