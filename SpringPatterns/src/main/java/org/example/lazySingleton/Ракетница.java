package org.example.lazySingleton;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy
public class Ракетница {

    @PostConstruct
    public void create() {
        System.out.println("Ракетница создана");
    }

    public void баБах() {
        System.out.println("Ракетница бабах!");
    }
}
