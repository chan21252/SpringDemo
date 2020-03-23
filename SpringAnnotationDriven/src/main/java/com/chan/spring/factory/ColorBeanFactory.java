package com.chan.spring.factory;

import com.chan.spring.pojo.color.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * ColorBeanFactory
 *
 * @author Chan
 * @since 2020/3/23
 */
public class ColorBeanFactory implements FactoryBean<Color> {
    public Color getObject() throws Exception {
        System.out.println("ColorBeanFactory.getObject()");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
