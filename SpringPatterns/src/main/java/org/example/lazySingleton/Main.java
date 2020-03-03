package org.example.lazySingleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
Смысл паттерна в том, что если мы декларируем бин как @Lazy, то и инжектит мы его должны @Lazy:
@Autowired
@Lazy
private Ракетница ракетница;

В противном случае контексту все равно - ракетница лейзи или не лейзи - он ее инжектит, а чтобы проинжектить он ее создает.
 */
public class Main {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Main.class.getPackageName());
        // Booom boom
    }
}
