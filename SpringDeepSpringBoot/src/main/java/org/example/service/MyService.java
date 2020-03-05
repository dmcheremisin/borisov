package org.example.service;

import org.example.bppForSpringBoot.annotations.Init;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Init
    public void init() {
        System.out.println(">>>>>> My SpringBoot Service >>>>> Init method");
    }

}
