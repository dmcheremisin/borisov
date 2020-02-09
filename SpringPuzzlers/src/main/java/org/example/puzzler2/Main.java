package org.example.puzzler2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.puzzler2")
@EnableAspectJAutoProxy
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        JokerConfService service = applicationContext.getBean(JokerConfService.class);
        service.pay();
        service.info();
        //JokerConfServiceImpl --> setup()
        //AuditManager is invoked for method --> pay
        //JokerConfServiceImpl --> pay()
        //Payment aspect is invoked
        //JokerConfServiceImpl --> info()
    }
}
