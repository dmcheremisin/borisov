package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Мы хотим чтобы наши аннотации в модуле SpringDeep отрабатывали автоматически.
Поэтому в модуле SpringDeep есть файлик spring.factories в META-INF.
Благодаря ему, без всякой дополнительной конфигурации, в нашем MyService -> init метод отрабатывает автоматически в
соответсвии с аннотацией @Init.
И печатается >>>>>> My SpringBoot Service >>>>> Init method
 */
@SpringBootApplication
public class SpringborisovApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringborisovApplication.class, args);
    }

    //Wife: I have nothing to wear
    //Husband: I will go fishing
    //Husband: Football is today
    //Wife: Where do you plan to go?
    //>>>>>> My SpringBoot Service >>>>> Init method
    //Husband: love is more important than 5000$
    //Wife: love is more important than  5000$

}
