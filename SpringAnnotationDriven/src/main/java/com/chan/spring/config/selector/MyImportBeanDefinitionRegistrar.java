package com.chan.spring.config.selector;

import com.chan.spring.pojo.color.Color;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * MyImportBeanDefinitionRegistry
 *
 * @author Chan
 * @since 2020/3/23
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean isBeanDefinition1 = beanDefinitionRegistry.containsBeanDefinition("com.chan.spring.pojo.color.Red");
        boolean isBeanDefinition2 = beanDefinitionRegistry.containsBeanDefinition("com.chan.spring.pojo.color.Green");

        if (isBeanDefinition1 && isBeanDefinition2) {
            RootBeanDefinition colorBeanDefinition = new RootBeanDefinition(Color.class);
            beanDefinitionRegistry.registerBeanDefinition("color", colorBeanDefinition);
        }
    }
}
