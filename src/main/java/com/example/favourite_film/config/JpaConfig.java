package com.example.favourite_film.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

import static java.sql.DriverManager.getConnection;

@Configuration
public class JpaConfig {
    private Connection connection;

    public JpaConfig() {
    }

    public JpaConfig(Connection connection) {
        this.connection = connection;
    }

    @Bean
    public Connection getConnections() {
        try {
            connection = getConnection("jdbc:mysql://34.66.101.166:3306/ngocnt", "ngocnt", "plusplus");;
            return connection;
        } catch (Exception e) {
            System.out.println("Loi khi connect database" + e);
        }
        return null;
    }
}
