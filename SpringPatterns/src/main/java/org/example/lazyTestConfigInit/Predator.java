package org.example.lazyTestConfigInit;

import org.springframework.stereotype.Component;

@Component
public class Predator {

    public Predator() {
        System.out.println(getClass().getSimpleName() + " was created");
    }

    public void killCommando(Commando commando) {
        if(commando instanceof Billy)
            return;
        commando.setAlive(false);
    }
}
