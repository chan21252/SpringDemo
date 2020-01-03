package com.chan.spring.bean.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private static final String CONTEXT_FILENAME = "com/chan/spring/conf/beans-factory.xml";

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(CONTEXT_FILENAME);

        Car car1 = (Car) app.getBean("car1");
        Car car2 = (Car) app.getBean("car2");
        Car car3 = (Car) app.getBean("carFactoryBean");
        Car car4 = (Car) app.getBean("carFactoryBean");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
        System.out.println(car3 == car4);
    }
}
