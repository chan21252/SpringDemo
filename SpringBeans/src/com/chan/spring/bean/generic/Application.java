package com.chan.spring.bean.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private static final String CONTEXT_FILENAME = "com/chan/spring/conf/beans-generic.xml";

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(CONTEXT_FILENAME);

        UserService userService = (UserService) app.getBean("userService");
        userService.add();
    }
}
