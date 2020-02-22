package org.example.puzzler1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Iron iron() {
        return new SolderingIron();
    }

}
