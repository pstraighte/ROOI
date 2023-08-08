package com.rooi.rooi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RooiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RooiApplication.class, args);
    }

}
