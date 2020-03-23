package com.chan.spring.config;

import com.chan.spring.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * MainConfigOfLifeCycle
 *
 * @author Chan
 * @since 2020/3/23
 */
public class MainConfigOfLifeCycle {

    @Scope("singleton")
    @Bean(name = "tom", initMethod = "init", destroyMethod = "destroy")
    public Person tom() {
        System.out.println("创建tom");
        return new Person("tom", 1, 1);
    }
}
