package com.example.questionservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class QuestionServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(QuestionServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner testDataSource(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection()) {
                System.out.println("✅ Connected to DB: " + conn.getMetaData().getDatabaseProductName());
                System.out.println("✅ Driver name: " + conn.getMetaData().getDriverName());
            } catch (SQLException e) {
                System.err.println("❌ Failed to connect to DB");
                e.printStackTrace();
            }
        };
    }

}
