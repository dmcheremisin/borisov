package org.example.lazyTestConfigInit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Main.class.getPackageName());
        //Billy was created
        //Dutch was created
        //Mac was created
    }
}
