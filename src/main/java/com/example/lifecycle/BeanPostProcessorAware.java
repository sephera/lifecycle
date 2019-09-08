package com.example.lifecycle;

import lombok.extern.flogger.Flogger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Flogger
@Component
public class BeanPostProcessorAware implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.atInfo().log("postProcessBeforeInitialization:%s", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.atInfo().log("postProcessAfterInitialization:%s", beanName);
        return bean;
    }
}
