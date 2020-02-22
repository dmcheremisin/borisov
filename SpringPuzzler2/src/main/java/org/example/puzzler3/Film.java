package org.example.puzzler3;

import org.example.puzzler3.actor.Actor;
import org.example.puzzler3.genre.Action;
import org.example.puzzler3.genre.Comedy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/*
Спринг инжектит только те бины, у которых есть все необходимые квалифайре.
 */
@Component
public class Film {

    @Autowired
    @Comedy
    @Action
    public List<Actor> actors;

    @PostConstruct
    public void printActors() {
        actors.forEach(System.out::println);
    }

}
