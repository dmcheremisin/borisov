package org.example.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Husband {

    @Autowired
    private Wife wife;

    @PostConstruct
    public void init(){
        System.out.println("Husband: Football is today");
        wife.saySomething();
    }

    public void doSomething() {
        System.out.println("Husband: I will go fishing");
    }
}
