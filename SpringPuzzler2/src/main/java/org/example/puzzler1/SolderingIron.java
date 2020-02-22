package org.example.puzzler1;

/*
Паяльник
 */
public class SolderingIron implements Iron {

    @Override
    public void heat() {
        System.out.println("Разогреваюсь медленно...");
    }

}
