package com.example.study_project_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudyProjectApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyProjectApiApplication.class, args);
    }
}