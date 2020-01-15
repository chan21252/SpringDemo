package com.chan.spring.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext监听器
 *
 * @author Chan
 */
public class SpringServletContextListener implements ServletContextListener {

    public SpringServletContextListener() {
        System.out.println("创建SpringServletContextListener");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听到初始化ServletContext");

        //获取Spring配置文件
        ServletContext servletContext = sce.getServletContext();
        String configLocation = servletContext.getInitParameter("contextConfigLocation");

        //创建IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

        //将IOC容器放在ServletContext的一个属性中
        servletContext.setAttribute("applicationContext", ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听到销毁ServletContext");
    }
}
