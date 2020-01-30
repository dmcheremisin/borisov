package org.example;

import org.example.quoters.Quoter;
import org.example.quoters.TerminatorQuoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        applicationContext.getBean(TerminatorQuoter.class).sayQuote();
    }
}
