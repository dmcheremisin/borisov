package org.example.lazyTestConfigInit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class.getPackageName());
        //Billy was created
        //Dutch was created
        //Mac was created
        //Predator was created
        Billy billy = context.getBean(Billy.class);
        Dutch dutch = context.getBean(Dutch.class);
        Predator predator = context.getBean(Predator.class);

        predator.killCommando(billy);
        predator.killCommando(dutch);

        System.out.println("Billy is alive: " + billy.isAlive());
        System.out.println("Dutch is alive: " + dutch.isAlive());
        //Billy is alive: true
        //Dutch is alive: false
    }
}
