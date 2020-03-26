package org.example.puzzler6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Order(1)
@Configuration
public class Config2 implements Config {

    @Bean
    @Override
    public String order() {
        return "2";
    }
}
