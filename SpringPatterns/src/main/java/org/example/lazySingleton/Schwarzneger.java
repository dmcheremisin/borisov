package org.example.lazySingleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Schwarzneger {

    @Autowired
    @Lazy
    private Ракетница ракетница;

    @EventListener(ContextRefreshedEvent.class)
    public void killEnemies() {
        if (enemiesQuantityMoreThan100())
            ракетница.баБах();
        else
            killWithPunches();
    }

    public void killWithPunches() {
        System.out.println("Booom boom");
    }

    private boolean enemiesQuantityMoreThan100() {
        return false;
    }
}
