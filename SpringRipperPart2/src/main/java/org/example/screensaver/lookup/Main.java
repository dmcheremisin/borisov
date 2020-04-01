package org.example.screensaver.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            Thread.sleep(500);
            context.getBean(ColorFrame.class).showOnRandomPlace();
        }
    }
}
