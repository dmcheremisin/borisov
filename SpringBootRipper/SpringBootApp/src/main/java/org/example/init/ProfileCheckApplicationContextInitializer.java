package org.example.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ProfileCheckApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        if (configurableApplicationContext.getEnvironment().getActiveProfiles().length == 0)
            throw new RuntimeException("You can't run application without profile");
    }
}
