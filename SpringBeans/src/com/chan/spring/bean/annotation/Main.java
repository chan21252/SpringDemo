package com.chan.spring.bean.annotation;

import com.chan.spring.bean.annotation.controller.UserController;
import com.chan.spring.bean.annotation.repository.UserRepository;
import com.chan.spring.bean.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/chan/spring/conf/beans-annotation.xml");
        TestObject testObject = (TestObject) ctx.getBean("testObject");
        UserRepository userRepository = (UserRepository) ctx.getBean("userRepositoryImp");
        UserService userService = (UserService) ctx.getBean("userService");
        UserController userController = (UserController) ctx.getBean("userController");

        System.out.println(testObject);
        System.out.println(userRepository);
        System.out.println(userService);
        System.out.println(userController);
    }
}
