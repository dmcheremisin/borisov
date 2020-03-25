package org.example.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/*
EnvironmentPostProcessor works before ApplicationContextInitializer.
So, ProfileDetectorPostProcessor will be invoked before ProfileCheckApplicationContextInitializer.
At this point active profile will be already set to default value.
We will check it and application will go on.

This class will be invoked according to spring.factories file.

This class was created only to demonstrate - how we can check environment parameters before application initialization.
 */
public class ProfileCheckApplicationContextInitializer implements
        ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        if (configurableApplicationContext.getEnvironment().getActiveProfiles().length == 0)
            throw new RuntimeException("You can't run application without profile");
    }
}
