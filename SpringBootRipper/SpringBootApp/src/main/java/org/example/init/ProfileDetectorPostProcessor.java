package org.example.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.example.consts.ProfileConstants.WINTER_IS_COMING;
import static org.example.consts.ProfileConstants.WINTER_IS_HERE;

/*
SpringApplication(org.springframework.boot.SpringApplication) creates environment(org.springframework.core.env.ConfigurableEnvironment).
Than this environment should be configured.
EnvironmentPostProcessor-s are created for environment configuration.
ProfileDetectorPostProcessor is one of these environment post processors.
It will be invoked by ConfigFileApplicationListener that listens to 2 events:
ApplicationEnvironmentPreparedEvent and ApplicationPreparedEvent.
And it will check profile and set default if no one would be passed.

This class will be invoked according to spring.factories file.
 */
public class ProfileDetectorPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        int profiles = environment.getActiveProfiles().length;
        if (profiles == 0) {
            if (getTemperature(environment) < -5)
                environment.setActiveProfiles(WINTER_IS_HERE);
            else
                environment.setActiveProfiles(WINTER_IS_COMING);
        }
    }

    private int getTemperature(ConfigurableEnvironment environment) {
        String temperature = environment.getProperty("temperature");
        return temperature != null ? Integer.parseInt(temperature) : 0;
    }
}
