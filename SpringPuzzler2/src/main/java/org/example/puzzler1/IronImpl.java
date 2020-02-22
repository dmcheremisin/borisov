package org.example.puzzler1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IronImpl implements Iron {

    @Override
    public void heat() {
        System.out.println("разогреваюсь...");
    }

    /*
    Это обычный сеттер метод, который помечен аннотацией @Autowired.
    Это наши трудности, что мы ничего не сеттим, но спринг найдет бин Water и сунет нам в метод.
    Поэтому его вызовет спринг в момент работы бин пост процессора и мы увидим в консоле:
    вода грейся...
     */
    @Autowired
    public void heatWater(Water water) {
        System.out.println(water + " грейся...");
    }

}
