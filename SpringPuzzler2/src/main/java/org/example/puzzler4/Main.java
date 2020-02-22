package org.example.puzzler4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
См. конфиг класс
 */
public class Main {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("org.example.puzzler4");
        //INFO: @Bean method Config.configurer is non-static and returns an object assignable to Spring's BeanFactoryPostProcessor interface.
        //C:\Program Files\Java\jdk-11.0.6
    }

}
