package org.example.puzzler2;

import org.springframework.stereotype.Component;

@Component
public class AuditManager {

    public void audit(String methodName) {
        System.out.println("AuditManager is invoked for method --> " + methodName);
    }

}
