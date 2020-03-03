package org.example.lazyTestConfigInit;

public abstract class Commando {

    private boolean alive;

    public Commando() {
        System.out.println(getClass().getSimpleName() + " was created");
    }
}
