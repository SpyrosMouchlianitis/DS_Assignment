package com.hua.gr.DS_Assignment;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4465141?");
        dataSourceBuilder.username("sql4465141");
        dataSourceBuilder.password("Z7i7r9IRAN");
        return dataSourceBuilder.build();
    }
}
