package com.dvd.Dvd;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean(name = "postgresSQL")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/dvdrental");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("1qazxsw2");
        return driverManagerDataSource;
    }
}
