package org.example.quoters.service.impl;

import org.example.quoters.service.Quoter;

public class T1000 extends TerminatorQuoter implements Quoter {

    @Override
    public void sayQuote() {
        System.out.println("I'm liquid iron!");
    }
}
