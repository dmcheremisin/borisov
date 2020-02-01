package org.example.quoters;

import org.example.quoters.service.impl.TerminatorQuoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        applicationContext.getBean(TerminatorQuoter.class).sayQuote();
    }
}
