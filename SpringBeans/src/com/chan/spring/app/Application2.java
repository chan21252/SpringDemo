package com.chan.spring.app;

import com.chan.spring.bean.lifecycle.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application2 {
    public static void main(String[] args) {
        String configXmlPath = "com/chan/spring/conf/";
        String configXmlFileName = "beans-lifecycle.xml";

        ApplicationContext app = new ClassPathXmlApplicationContext(configXmlPath + configXmlFileName);

        Car car1 = (Car) app.getBean("car1");
        Car car2 = (Car) app.getBean("car2");
        System.out.println(car1);
        System.out.println(car2);
    }
}
