package org.example.quoters;

import org.example.quoters.service.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        while (true) {
            Thread.sleep(200);
            applicationContext.getBean(Quoter.class).sayQuote();
        }

    }
}
