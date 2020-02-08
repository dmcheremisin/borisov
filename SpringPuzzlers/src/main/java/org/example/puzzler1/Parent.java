package org.example.puzzler1;

import javax.annotation.PostConstruct;

public class Parent {
    @PostConstruct
    private void init() {
        System.out.println("Папа");
    }
}
