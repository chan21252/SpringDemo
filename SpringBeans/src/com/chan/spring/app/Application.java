package com.chan.spring.app;

import com.chan.spring.bean.Car;
import com.chan.spring.bean.Person;
import com.chan.spring.bean.collection.CarShopList;
import com.chan.spring.bean.collection.CarShopSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private static final String CONTEXT_FILENAME = "com/chan/spring/conf/applicationContext.xml";

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(CONTEXT_FILENAME);
        Car car1 = (Car) app.getBean("car1");
        Car car2 = (Car) app.getBean("car2");
        Car car3 = (Car) app.getBean("car3");

        Person person1 = (Person) app.getBean("person1");
        Person person2 = (Person) app.getBean("person2");
        Person person3 = (Person) app.getBean("person3");

        CarShopList carShop1 = (CarShopList) app.getBean("carShop1");
        CarShopSet carShop2 = (CarShopSet) app.getBean("carShop2");

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        System.out.println(carShop1);
        System.out.println(carShop2);
    }
}
