package org.example.bppForSpringBoot.models;

import lombok.Getter;
import org.example.bppForSpringBoot.annotations.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Husband {
    @Autowired
    private Wife wife;

    @Getter
    private String money;

    @Init
    public void afterInitialization() {
        System.out.println("Husband: " + wife.getLove() + " is more important than " + money);
    }

    @PostConstruct
    public void init() {
        money = "5000$";
    }

    public void doSomething() {
        System.out.println("Husband: I will go fishing");
    }

}
