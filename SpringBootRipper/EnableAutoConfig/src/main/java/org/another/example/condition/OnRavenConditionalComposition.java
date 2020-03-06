package org.another.example.condition;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
//import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

//AllNestedConditions or AnyNestedCondition are possible for condition composition
//public class OnRavenConditionalComposition extends AnyNestedCondition {
public class OnRavenConditionalComposition extends AllNestedConditions {

    public OnRavenConditionalComposition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnProperty("raven.whereToGo")
    public static class w {}

    @ConditionalOnProperty(value = "raven.enabled", havingValue = "true")
    public static class e {}

}
