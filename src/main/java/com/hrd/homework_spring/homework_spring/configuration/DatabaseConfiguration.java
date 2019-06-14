package com.hrd.homework_spring.homework_spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    @Bean
    @Profile("LocalDB")
    public DataSource dataSource(){
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName("org.postgresql.Driver");
        db.setUrl("jdbc:postgresql://localhost:5432/ARTICLE_DB");
        db.setUsername("postgres");
        db.setPassword("Lunsim");
        return db;
    }

    @Bean
    @Profile("memory")
    public DataSource dataSourceMemory(){
        EmbeddedDatabaseBuilder em = new EmbeddedDatabaseBuilder();
        em.setType(EmbeddedDatabaseType.H2);
        em.addScripts("classpath:/static/sql/createTable.sql","classpath:/static/sql/addCategory.sql");
        return em.build();
    }
}
