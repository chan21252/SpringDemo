package com.chan.spring.bean.collection;

import java.util.Properties;

/**
 * 数据源配置
 */
public class DataSource {
    private Properties properties;

    public DataSource() {
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
