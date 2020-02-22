package org.example.puzzler3.actor;

import org.example.puzzler3.genre.Action;
import org.example.puzzler3.genre.Comedy;
import org.springframework.stereotype.Component;

@Component @Comedy @Action
public class Stallone implements Actor {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
