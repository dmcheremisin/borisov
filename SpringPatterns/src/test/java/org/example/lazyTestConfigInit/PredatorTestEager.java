package org.example.lazyTestConfigInit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/*
Будут созданы все бины
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockConfigurationEager.class)
public class PredatorTestEager {

    @Autowired
    private Billy billy;

    @Autowired
    private Predator predator;

    @Test
    public void shouldNotKillBillyWhenPredatorAttack() {
        predator.killCommando(billy);
        assertTrue(billy.isAlive());
        //Billy was created
        //Dutch was created
        //Mac was created
        //Predator was created
    }

}