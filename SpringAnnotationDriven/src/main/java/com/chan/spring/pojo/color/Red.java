package com.chan.spring.pojo.color;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Red
 *
 * @author Chan
 * @since 2020/3/23
 */
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("传入的IOC容器：" + applicationContext);
    }


    public void setBeanName(String s) {
        System.out.println("传入的BeanName：" + s);
    }


    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String value = stringValueResolver.resolveStringValue("数据库用户名： ${jdbc.username}，2+3=#{2+3}");
        System.out.println("字符串解析结果：" + value);
    }
}
