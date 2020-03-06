package org.another.example.configuration;

import org.another.example.annotation.ConditionOnProduction;
import org.another.example.listener.RavenListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Without spring.factories file this configuration(AutoConfig.class) will not be auto initialized in SpringBootApp
 */
@Configuration
public class AutoConfig {

    @Bean
    @ConditionOnProduction // will ask for the first time about - is it production?
    public RavenListener getRavenListener() {
        return new RavenListener();
    }

    @Bean
    @ConditionOnProduction // will ask for the second time about - is it production?, so evaluated 2 times instead of 1
    public String getStringBean() {
        String stringBean = "String bean requested";
        System.out.println(stringBean);
        return stringBean;
    }

}
