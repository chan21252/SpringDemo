package com.chan.spring.config;

import com.chan.spring.pojo.JDBC;
import com.chan.spring.pojo.color.Red;
import com.chan.spring.service.PersonService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * MainConfigOfLifeCycle
 *
 * @author Chan
 * @since 2020/3/23
 */
@Configuration
@ComponentScan(basePackages = {"com.chan.spring"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class, Repository.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Red.class})
}, useDefaultFilters = false)
@PropertySource(value = {"classpath:/jdbc.properties"})
public class MainConfigPropertyValue {

    @Bean()
    public JDBC jdbc() {
        return new JDBC();
    }

    @Bean("personService1")
    public PersonService personService1() {
        PersonService personService = new PersonService();
        personService.setLabel("1");
        System.out.println("@Bean-->" + personService);
        return personService;
    }

    @Primary
    @Bean("personService2")
    public PersonService personService2() {
        PersonService personService = new PersonService();
        personService.setLabel("2");
        System.out.println("@Bean-->" + personService);
        return personService;
    }
}
