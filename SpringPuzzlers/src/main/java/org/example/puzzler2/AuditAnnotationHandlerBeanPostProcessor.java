package org.example.puzzler2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Правило: Все проксирование засовываем в postProcessAfterInitialization, так как можем сломать BeanPostProcessor-ы спринга

Если используються аспекты, то надо знать, что аспекты срабатывают во время инициализации бина. Из этого следует
правило: не привязываться к bean.getClass(), так как есть вероятность получить Proxy.
Для этого испольуем мапу для запоминания оригинальных классов до инициализации бина.
 */

@Component
public class AuditAnnotationHandlerBeanPostProcessor implements BeanPostProcessor {
    private final AuditManager auditManager;
    private Map<String, Pair<Class, List<Method>>> map;

    public AuditAnnotationHandlerBeanPostProcessor(AuditManager auditManager) {
        this.auditManager = auditManager;
        map = new HashMap<>();
    }

    /*
    Запоминаем все бины у которых есть аннотация Audit в мапу для того, чтобы потом по бин нейму достать.
     */

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        List<Method> declaredMethods = Arrays.asList(beanClass.getDeclaredMethods());
        List<Method> auditMethods = declaredMethods.stream()
                .filter(m -> m.isAnnotationPresent(Audit.class))
                .collect(Collectors.toList());
        if (!auditMethods.isEmpty())
            map.put(beanName, new Pair<>(beanClass, auditMethods));

        return bean;
    }

    /*
    В этот метод приходит объект bean. Это будет оригинальный объект или уже прокси мы не знаем, но скорее всего прокси.
    Прокси - это абсолютно другой объект, у которого нет оригинальных аннотаций.
    Соответсвенно нужно найти в мапе тот, оригинальный объект, по запомненному бин нейму.
    Если он есть, значит нужно обогатить его методы нужным функционалом.
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            Class beanClass = map.get(beanName).getKey();
            List<Method> auditMethods = map.get(beanName).getValue();

            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                if (auditMethods.stream().anyMatch(m -> m.getName().equals(method.getName())))
                    auditManager.audit(method.getName());

                return method.invoke(bean, args);
            });
        }

        return bean;
    }
}
