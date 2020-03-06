package org.another.example.listener;

import lombok.RequiredArgsConstructor;
import org.another.example.configuration.RavenProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@RequiredArgsConstructor
public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {

    private final RavenProperties ravenProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ravenProperties.getWhereToGo().forEach(p -> System.out.println("A raven was sent to: " + p));
    }
}
