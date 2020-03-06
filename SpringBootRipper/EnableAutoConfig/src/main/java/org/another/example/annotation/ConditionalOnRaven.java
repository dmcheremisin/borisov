package org.another.example.annotation;

import org.another.example.condition.OnRavenConditionalComposition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnRavenConditionalComposition.class)
public @interface ConditionalOnRaven {

}
