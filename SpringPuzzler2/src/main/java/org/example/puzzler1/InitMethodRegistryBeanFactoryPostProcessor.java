package org.example.puzzler1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;

/*
В этом классе мы пытаемся решить проблему того, что спринг не учитывает инит методы в интерфейсах.
А мы хотели бы установить контракт на инит метод именно там.
Наш класс Iron имеет аннотацию @PostConstruct над методом heat(), её мы и попытаемся обработать.
Для этого нам нужно поправить beanDefinition для класса IronImpl(это наш целевой бин).
За бин дефинишены отвечают классы, которые имплементируют интерфейс BeanFactoryPostProcessor.
Нам нужно имплементировать только один метод postProcessBeanFactory и добавить туда свою логику.
 */
@Component
public class InitMethodRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(name);
            Class<?> beanClass = getBeanClassName(beanDefinition);
            Class<?>[] interfacesForClass = ClassUtils.getAllInterfacesForClass(beanClass);

            for (Class<?> ifc : interfacesForClass) {
                Method[] methods = ifc.getMethods();

                for (Method method : methods) {
                    boolean isAnnotationPostConstruct = method.isAnnotationPresent(PostConstruct.class);
                    if (isAnnotationPostConstruct)
                        beanDefinition.setInitMethodName(method.getName());
                }
            }
        }
    }

    /*
    У нас все хорошо работает до того момента, пока мы не решаем установить бин в конфигурацинном файле - Config.
    Спринг не может определить класс его бина, т.к. его класс - это возвращаемое значение метода.
    Придется его доставать самостоятельно, используя для этого самописную утилиту - SpringMethodMetaDataUtil
     */
    private Class<?> getBeanClassName(AbstractBeanDefinition beanDefinition) {
        String beanClassName = beanDefinition.getBeanClassName();

        if (beanClassName == null)
            beanClassName = SpringMethodMetaDataUtil.getReturnType(beanDefinition);

        return ClassUtils.resolveClassName(beanClassName, null);
    }
}
