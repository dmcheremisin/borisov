package org.example.puzzler3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.puzzler3")
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        JokerConfService service = applicationContext.getBean(JokerConfService.class);
        service.transferMoney();
        //Withdraw
        //Deposit
        //Exception in thread "main" java.lang.RuntimeException: Something went wrong
    }
}
