package org.another.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Without spring.factories file this configuration(AutoConfig.class) will not be auto initialized in SpringBootApp
 */
@Configuration
public class AutoConfig {

    @Bean
    public RavenListener getRavenListener() {
        return new RavenListener();
    }

}
