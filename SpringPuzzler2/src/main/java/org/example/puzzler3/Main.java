package org.example.puzzler3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
Этот пазлер был про то, как спринг учитывает квалифайеры.
Спринг инжектит только те бины, у которых есть все необходимые квалифайре.
Поэтому у компонента Film будут только Чак Норрис и Сталлоне, т.к. только у них есть ВСЕ необходимые квалифайеры.
 */
public class Main {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("org.example.puzzler3");
        //Chuck
        //Stallone
    }

}
