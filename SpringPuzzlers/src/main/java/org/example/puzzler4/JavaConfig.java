package org.example.puzzler4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public String str(){
        return "Test string";
    }
}
