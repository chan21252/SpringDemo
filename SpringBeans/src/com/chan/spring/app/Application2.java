package com.chan.spring.app;

import com.chan.spring.bean.autowire.Address;
import com.chan.spring.bean.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application2 {
    public static void main(String[] args) {
        String configXmlPath = "com/chan/spring/conf/";
        String configXmlFileName = "beans-relation.xml";

        ApplicationContext app = new ClassPathXmlApplicationContext(configXmlPath + configXmlFileName);
        Address address1 = (Address) app.getBean("address1");
        Address address2 = (Address) app.getBean("address2");
        Address address3 = (Address) app.getBean("address3");
        Address address4 = (Address) app.getBean("address4");

        Person person1 = (Person) app.getBean("person1");


        System.out.println(address1);
        System.out.println(address2);
        System.out.println(address3);
        System.out.println(address4);
        System.out.println(person1);
    }
}
