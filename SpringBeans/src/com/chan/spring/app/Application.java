package com.chan.spring.app;

import com.chan.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private static final String CONTEXT_FILENAME = "com/chan/spring/conf/beans-spel.xml";

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(CONTEXT_FILENAME);
        //DataSource ds = (DataSource) app.getBean("dataSource");
        //System.out.println(ds);

        Person person1 = (Person) app.getBean("person1");
        System.out.println(person1);
    }
}
