package com.example.lifecycle;

import lombok.extern.flogger.Flogger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Flogger
@Component
public class BeanFactoryPostProcessorAware implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.atInfo().log("BeanFactoryPostProcessorAware.postProcessBeanFactory() called");
    }
}
