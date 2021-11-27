package com.lab6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.lab6.controllers", "com.lab6.service", "com.lab6.exceptions","com.lab6.repository","com.lab6.config"})
@EntityScan({"com.lab6.models"})
@EnableJpaRepositories("com.lab6.repository")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}