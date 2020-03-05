package org.example.bppForSpringBoot.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitAnnotationConfig {

    @Bean
    public InitInvokerContextListener actionInvokerContextListener(ConfigurableListableBeanFactory beanFactory) {
        return new InitInvokerContextListener(beanFactory);
    }

    @Bean
    BeanDefinitionAppenderBeanPostProcessor beanDefinitionAppenderBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        return new BeanDefinitionAppenderBeanPostProcessor(beanFactory);
    }
}
