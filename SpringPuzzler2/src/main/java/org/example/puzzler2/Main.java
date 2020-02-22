package org.example.puzzler2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
Тут пазлер был в том, что спринг до 5ой версии не мог понять, что можно инжектить лист стрингов в лист стрингов.
Он пытался собрать сам лист из отдельных бинов того же класса(BaruchConfig) и проинжектить его в класс, который требует лист(JekaService).
Но у JekaService стоит @JekaQualifier, спринг пытался найти бины с таким квалифайером, не находил их и валился.
Но видимо в 5ой версии это дело починили и все сейчас работает как надо.
 */
public class Main {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("org.example.puzzler2");
        //----- BaruchService -----
        //Groovy
        //Spring
        //Artifactory
        //----- JekaService -----
        //Java
        //Scala
    }

}
