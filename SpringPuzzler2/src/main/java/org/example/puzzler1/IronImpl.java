package org.example.puzzler1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IronImpl implements Iron {

    @Override
    public void heat() {
        System.out.println("разогреваюсь...");
    }

    @Autowired
    public void heatWater(Water water) {
        System.out.println(water + " грейся...");
    }

}
