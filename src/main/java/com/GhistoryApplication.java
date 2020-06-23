package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class GhistoryApplication{
    public static void main(String[] args) {
        SpringApplication.run(GhistoryApplication.class,args);
    }
}
