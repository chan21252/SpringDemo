package com.chan.spring.config.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * MyImportSelector
 *
 * @author Chan
 * @since 2020/3/23
 */
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.chan.spring.pojo.color.Red", "com.chan.spring.pojo.color.Green"};
    }
}
