package org.another.example.configuration;

import org.another.example.annotation.ConditionOnProduction;
import org.another.example.annotation.ConditionalOnRaven;
import org.another.example.listener.RavenListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Without spring.factories file this configuration(AutoConfig.class) will not be auto initialized in SpringBootApp
 */
@Configuration
@EnableConfigurationProperties(RavenProperties.class)
public class AutoConfig {

    @Bean
    @ConditionOnProduction // will ask for the first time about - is it production?
    @ConditionalOnRaven
    @ConditionalOnMissingBean
    public RavenListener getRavenListener(RavenProperties ravenProperties) {
        return new RavenListener(ravenProperties);
    }

    @Bean
    @ConditionalOnProperty("stringBean.enabled")
    @ConditionOnProduction // will ask for the second time about - is it production?, so evaluated 2 times instead of 1
    public String getStringBean() {
        String stringBean = "String bean enabled";
        System.out.println(stringBean);
        return stringBean;
    }

}
