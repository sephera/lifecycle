package com.example.lifecycle;

import lombok.extern.flogger.Flogger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Implementing these interfaces will couple the code to the Spring framework
 * So, Don't do that!
 */
@Flogger
@Component
public class LoggingBeanNameAware implements BeanNameAware, BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanName(String name) {
        log.atInfo().log("Init:%s", name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @PostConstruct
    public void init() {
        try {
            LoggingBeanNameAware bean = beanFactory.getBean(LoggingBeanNameAware.class);
            log.atInfo().log("Init ok! %s", bean.toString());
        } catch (BeansException ignored) {
            log.atInfo().log("The bean could not be created");
        }
    }
}
