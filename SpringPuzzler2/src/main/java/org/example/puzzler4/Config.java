package org.example.puzzler4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;

@Configuration
public class Config {

    @Value("${JAVA_HOME}")
    private String javaHome;

    @PostConstruct
    public void init() {
        System.out.println("javaHome = " + javaHome);
    }

    /*
    PropertySourcesPlaceholderConfigurer - это BeanFactoryPostProcessor. Он должен создаваться во время сбора бин дефинишенов.
    Если мы декларируем его в конфиге(это тоже бин), то он будет проинициализирован самым первым и для него не будет работать ничего.
    Не отработает ни постконстракт, ни @Value, ничего.
    Вместе с тем спринг напишет ворнинг:
    INFO: @Bean method Config.configurer is non-static and returns an object assignable to Spring's BeanFactoryPostProcessor interface.
    Нужно этот метод пометить статическим, чтобы все заработало и BeanFactoryPostProcessor создался бы раньше бин пост процессоров.
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

//    Вот так все будет ок, т.к. метод стал статическим.
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer configurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
