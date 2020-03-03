package org.example.springVsSwitch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class.getPackageName());

        PostmanPechkin postmanPechkin = context.getBean(PostmanPechkin.class);
        postmanPechkin.sendMessage("Viber");//Viber message
        postmanPechkin.sendMessage("WhatsUp");//WhatsUp message
        postmanPechkin.sendMessage("SMS");//SMS message
    }
}
