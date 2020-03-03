package org.example.lazyTestConfigInit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Commando {

    private boolean alive;

    public Commando() {
        alive = true;
        System.out.println(getClass().getSimpleName() + " was created");
    }
}
