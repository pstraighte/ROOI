package com.rooi.rooi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig { // passwordConfig

    @Bean
    public PasswordEncoder passwordEncoder() { //passwordEncoder
        return new BCryptPasswordEncoder(); //PasswordEncoder 는 interface 라 구현체 BCryptPasswordEncoder 필요
    }
}