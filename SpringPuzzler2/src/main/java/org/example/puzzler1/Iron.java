package org.example.puzzler1;

import javax.annotation.PostConstruct;

public interface Iron {

    /*
    Аннотации в интерфейсах для спринга не работают
     */
    @PostConstruct
    void heat();

}
