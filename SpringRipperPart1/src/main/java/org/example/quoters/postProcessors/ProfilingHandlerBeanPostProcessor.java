package org.example.quoters.postProcessors;

import org.example.quoters.annotations.Profiling;
import org.example.quoters.controller.ProfilingController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private ProfilingController controller = new ProfilingController();
    private Map<String, Class> map = new HashMap<>();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class))
            map.put(beanName, beanClass);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                if (controller.isEnabled()) {
                    System.out.println("Profiling...");
                    long before = System.nanoTime();
                    Object returnValue = method.invoke(bean, args);
                    long after = System.nanoTime();
                    System.out.println("Timing: " + (after - before));
                    System.out.println("Ended profiling");
                    return returnValue;
                }
                return method.invoke(bean, args);
            });
        }
        return bean;
    }
}
