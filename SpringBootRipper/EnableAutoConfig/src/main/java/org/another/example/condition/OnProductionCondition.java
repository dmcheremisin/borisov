package org.another.example.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.swing.JOptionPane;

public class OnProductionCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.setProperty("java.awt.headless", "false");
        return JOptionPane.showConfirmDialog(null, "Is it production?") == 0;
    }
}
