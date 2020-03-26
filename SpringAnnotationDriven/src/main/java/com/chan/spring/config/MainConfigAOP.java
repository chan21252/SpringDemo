package com.chan.spring.config;

import com.chan.spring.aop.MathCalculator;
import com.chan.spring.aop.MathCalculatorAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * MainConfigAOP
 *
 * @author Chan
 * @since 2020/3/26
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigAOP {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public MathCalculatorAspect mathCalculatorAspect() {
        return new MathCalculatorAspect();
    }
}
