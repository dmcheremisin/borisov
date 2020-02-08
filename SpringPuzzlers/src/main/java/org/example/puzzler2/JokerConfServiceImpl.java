package org.example.puzzler2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Audit
@Component
public class JokerConfServiceImpl implements JokerConfService {

    @PostConstruct
    public void setup() {
        System.out.println("JokerConfServiceImpl --> setup()");
    }

    public void pay() {
        System.out.println("JokerConfServiceImpl --> pay()");
    }

    public void info() {
        System.out.println("JokerConfServiceImpl --> info()");
    }
}
