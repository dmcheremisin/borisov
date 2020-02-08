package org.example.puzzler3;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
Rollback произойдет на все методы, хотя можно было подумать, что только на методе infoBankManager.
Не происходит проксирование метода, который вызываеться в методе тогоже класса.
Решение - самовпрыскивание! (@SelfAutowired)
 */

@Component
@JokerConfTransactional
public class JokerConfService {

    /*
    С версии 4.3 @Autowired работает также, как и @SelfAutowired
     */
    @SelfAutowired
    private JokerConfService proxy;

    public void transferMoney() {
        proxy.withdraw();
        proxy.deposit();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void withdraw() {
        System.out.println("Withdraw");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deposit() {
        System.out.println("Deposit");
        proxy.infoBankManager();
    }

    private void infoBankManager() {
        //генерит exception
        throw new RuntimeException("Something went wrong");
    }
}
