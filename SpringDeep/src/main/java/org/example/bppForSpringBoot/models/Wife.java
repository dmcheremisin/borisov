package org.example.bppForSpringBoot.models;

import lombok.Getter;
import org.example.bppForSpringBoot.annotations.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Wife {

    @Autowired
    private Husband husband;

    @Getter
    private String love;

    @Init
    public void afterInitialization() {
        System.out.println("Wife: " + love + " is more important than  " + husband.getMoney().toUpperCase() );
    }

    @PostConstruct
    public void init() {
        love = "love";
    }

    public void saySomething() {
        System.out.println("Wife: where are you going?");
    }

}
