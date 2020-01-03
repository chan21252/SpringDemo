package com.chan.spring.bean.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private static final String CONTEXT_FILENAME = "com/chan/spring/conf/beans-spel.xml";

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(CONTEXT_FILENAME);

        Person person1 = (Person) app.getBean("person1");
        System.out.println(person1);
    }
}
