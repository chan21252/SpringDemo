package com.chan.spring.app;

import com.chan.spring.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 应用类，程序入口
 *
 * @author Chan
 */
public class Application {
    public static void main(String[] args) {
        //创建Spring IOC容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从IOC容器获取对象
        Student stu1 = (Student) context.getBean("stu1");

        //调用对象hello方法
        stu1.hello();
    }
}
