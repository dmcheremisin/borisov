package org.example.puzzler6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 implements Config {

    @Bean
    @Override
    public String order() {
        return "1";
    }
}
