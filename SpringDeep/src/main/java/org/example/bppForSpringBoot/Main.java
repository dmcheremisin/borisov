package org.example.bppForSpringBoot;

import org.example.bppForSpringBoot.annotations.EnableInitAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableInitAnnotation
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Main.class.getPackageName());
        //Husband: love is more important than 5000$
        //Wife: love is more important than  5000$
    }
}
