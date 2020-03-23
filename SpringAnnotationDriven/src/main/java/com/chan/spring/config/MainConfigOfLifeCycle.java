package com.chan.spring.config;

import com.chan.spring.pojo.Person;
import com.chan.spring.pojo.animal.Cat;
import org.springframework.context.annotation.*;

/**
 * MainConfigOfLifeCycle
 *
 * @author Chan
 * @since 2020/3/23
 */
@Configuration
@ComponentScan(basePackages = "com.chan.spring", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MyBeanPostProcessor.class})
}, useDefaultFilters = false)
public class MainConfigOfLifeCycle {

    @Scope("singleton")
    @Bean(name = "tom", initMethod = "init", destroyMethod = "destroy")
    public Person tom() {
        System.out.println("创建tom");
        return new Person("tom", 1, 1);
    }

    @Bean(name = "didi", initMethod = "init", destroyMethod = "destroy2")
    public Cat didi() {
        System.out.println("创建弟弟");
        Cat didi = new Cat();
        didi.setName("弟弟");
        return didi;
    }
}
