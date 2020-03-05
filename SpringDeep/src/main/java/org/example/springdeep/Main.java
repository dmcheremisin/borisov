package org.example.springdeep;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class.getPackageName());
        //Wife: I have nothing to wear
        //Husband: I will go fishing
        //Husband: Football is today
        //Wife: Where do you plan to go?
    }
}
