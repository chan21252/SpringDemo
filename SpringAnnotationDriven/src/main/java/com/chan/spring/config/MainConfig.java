package com.chan.spring.config;

import com.chan.spring.config.condition.LinuxCondition;
import com.chan.spring.config.condition.WindowsCondition;
import com.chan.spring.config.filter.MyComponentScanFilter;
import com.chan.spring.config.selector.MyImportBeanDefinitionRegistrar;
import com.chan.spring.config.selector.MyImportSelector;
import com.chan.spring.factory.ColorBeanFactory;
import com.chan.spring.pojo.Person;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * MainConfig
 *
 * @author Chan
 * @since 2020/3/23
 */
@Configuration
@ComponentScan(basePackages = "com.chan.spring", includeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class, Repository.class}),
        @Filter(type = FilterType.CUSTOM, classes = MyComponentScanFilter.class)
}, useDefaultFilters = false)
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {

    @Scope("prototype")
    @Lazy
    @Bean(name = "bob")
    public Person bob() {
        System.out.println("添加Bob到IOC容器");
        return new Person("Bob", 20, 1);
    }

    @Bean("bill")
    @Conditional(WindowsCondition.class)
    public Person bill() {
        return new Person("bill", 20, 1);
    }

    @Bean("linus")
    @Conditional(LinuxCondition.class)
    public Person linus() {
        return new Person("linus", 20, 1);
    }

    @Bean
    public ColorBeanFactory colorBeanFactory() {
        return new ColorBeanFactory();
    }
}
