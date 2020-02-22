package org.example.puzzler5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/*
Прототайпы создаются только, когда их кто-то запрашивает.
Синглтоны создаются заранее и на них есть ссылки в контексте спринга.

Спринг не хранит прототайпы в контексте, он создает их и передает тому, кто запросил, он нигде не хранит прототайп.
Когда контекст закрывается, дестрой методы будут вызваны только у синглтонов, т.к. на них есть ссылк в контексте
 */
public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.example.puzzler5");
        applicationContext.close();

//        Warning: found destroy method for bean 't800' with scope prototype
//        T800-init()
//        T1000-init()
//        T1000-destroy()
    }

}
