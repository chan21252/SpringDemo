package com.chan.spring.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * WindowsCondition
 *
 * @author Chan
 * @since 2020/3/23
 */
public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String os = conditionContext.getEnvironment().getProperty("os.name");
        System.out.println(os);
        return os.contains("Windows");
    }
}
