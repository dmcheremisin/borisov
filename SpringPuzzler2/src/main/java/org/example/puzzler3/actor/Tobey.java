package org.example.puzzler3.actor;

import org.example.puzzler3.genre.Action;
import org.springframework.stereotype.Component;

@Component @Action
public class Tobey implements Actor {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
