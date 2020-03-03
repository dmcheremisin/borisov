package org.example.lazyTestConfigInit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
lazyInit = true - говорит о том, что нужно создавать только те бины, которые реально будут запрошены в тесте
 */
@Configuration
@ComponentScan(lazyInit = true)
public class MockConfigurationLazy {
}
