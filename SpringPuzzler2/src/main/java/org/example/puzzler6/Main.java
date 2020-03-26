package org.example.puzzler6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("org.example.puzzler6");
        String order = ctx.getBean("order", String.class);
        System.out.println(order); // 1, because Config1 will be initialized after Config2 according to @Order
    }

}
