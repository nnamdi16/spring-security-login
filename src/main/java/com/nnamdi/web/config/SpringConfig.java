package com.nnamdi.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.nnamdi.web"})
public class SpringConfig {

//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/user_db");
//        dataSource.setUsername("root");
//        dataSource.setPassword("nnamdI2k18#");
//        return dataSource;
//    }
//
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(getDataSource());
//        return jdbcTemplate;
//    }
    /**
     * @Configuration annotation indicates that the class declares one or more @Bean methods which will be processed by the Spring container to generate bean definitions
     * @EnableWebMVc is equivalent to <mvc:annotation-driven/> . It enables support for @Controller, @RestController etc.. annotated classes.
     * The data source bean consists og all the connection related details which are needed to connect to the database.
     */
}
