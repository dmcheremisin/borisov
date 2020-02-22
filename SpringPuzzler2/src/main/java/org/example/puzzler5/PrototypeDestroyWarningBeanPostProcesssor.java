package org.example.puzzler5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.lang.reflect.Method;

/*
Постпроцессор, который пишет ворнинг, чтобы мы не делали дестрой методов, для бинов со скоупом прототайп.
 */
@Component
public class PrototypeDestroyWarningBeanPostProcesssor implements BeanPostProcessor {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
        if (beanDefinition.isPrototype()) {
            if (beanDefinition.getDestroyMethodName() != null) {
                printWarning(beanName);
                return bean;
            }
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PreDestroy.class)) {
                    printWarning(beanName);
                    return bean;
                }
            }
        }
        return bean;
    }

    private void printWarning(String beanName) {
        System.err.println(String.format("Warning: found destroy method for bean '%s' with scope prototype", beanName));
    }

}
