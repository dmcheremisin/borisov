package org.example.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("circular-wife")
public class Wife {

    @Autowired
    private Husband husband;

    @PostConstruct
    public void init(){
        System.out.println("Wife: I have nothing to wear");
        husband.doSomething();
    }

    public void saySomething() {
        System.out.println("Wife: Where do you plan to go?");
    }
}
