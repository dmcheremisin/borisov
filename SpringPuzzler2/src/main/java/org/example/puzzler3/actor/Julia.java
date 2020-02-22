package org.example.puzzler3.actor;

import org.example.puzzler3.genre.Melodrama;
import org.springframework.stereotype.Component;

@Component @Melodrama
public class Julia implements Actor {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
