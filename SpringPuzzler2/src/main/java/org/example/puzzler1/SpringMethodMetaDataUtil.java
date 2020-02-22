package org.example.puzzler1;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.type.MethodMetadata;

import java.lang.reflect.Field;

/*
Так как в javaConfig в BeanDefinition отсудствует названия класса,
то мы достаем возвращаемый класс из ConfigurationClassBeanDefinition.

Можно было бы достать из бина, но мы идем на такие ухищрения, так как нам нужно узнать класс до создания бина
 */
public class SpringMethodMetaDataUtil {

    public static String getReturnType(BeanDefinition beanDefinition) {
        MethodMetadata methodMetadata = (MethodMetadata) beanDefinition.getSource();
        return methodMetadata.getReturnTypeName();
    }

    /*
    Это женина имплементация, есть вариант короче.
    В спринг 5 появился класс SimpleMethodMetadata, через который можно гораздо проще вытащить возвращаемое значение метода.
     */
    public static String oldGetMethodReturnType(BeanDefinition beanDefinition) {
        try {
            Object reader = Class.forName("org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader$ConfigurationClassBeanDefinition").cast(beanDefinition);
            Field field = reader.getClass().getDeclaredField("factoryMethodMetadata");
            field.setAccessible(true);
            MethodMetadata visitor = (MethodMetadata) field.get(reader);
            return visitor.getReturnTypeName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
