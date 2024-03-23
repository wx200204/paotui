package com.example.newsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class NewsBApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsBApplication.class, args);
    }

}
