package org.example.puzzler2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class JekaService {

    @Autowired
    @JekaQualifier
    private List<String> list;

    @PostConstruct
    public void print() {
        System.out.println("----- JekaService -----");
        list.forEach(System.out::println);
    }
}
