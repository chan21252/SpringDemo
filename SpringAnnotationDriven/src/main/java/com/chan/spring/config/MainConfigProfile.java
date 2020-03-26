package com.chan.spring.config;

import com.chan.spring.pojo.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * MainConfigProfile
 *
 * @author Chan
 * @since 2020/3/26
 */
@PropertySource(value = "classpath:datasource.properties")
@Configuration
public class MainConfigProfile {
    @Profile("test")
    @Bean
    public DataSource testDataSource(@Value("${test.datasource.username}") String username,
                                     @Value("${test.datasource.password}") String password) {
        DataSource dataSource = new DataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");

        return dataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource devDataSource(@Value("${dev.datasource.username}") String username,
                                    @Value("${dev.datasource.password}") String password) {
        DataSource dataSource = new DataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dev");

        return dataSource;
    }

    @Profile("product")
    @Bean
    public DataSource productDataSource(@Value("${product.datasource.username}") String username,
                                        @Value("${product.datasource.password}") String password) {
        DataSource dataSource = new DataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/product");

        return dataSource;
    }
}
