package com.example.lifecycle;

import lombok.extern.flogger.Flogger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Implementing these interfaces will couple the code to the Spring framework
 * So, Don't do that!
 */
@Flogger
@Component
public class LoggingBeanAware implements BeanNameAware, BeanFactoryAware, DisposableBean {
    private BeanFactory beanFactory;

    @Override
    public void setBeanName(String name) {
        log.atInfo().log("LoggingBeanAware:setBeanName:%s", name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @PostConstruct
    public void init() {
        try {
            LoggingBeanAware bean = beanFactory.getBean(LoggingBeanAware.class);
            log.atInfo().log("LoggingBeanAware.PostConstructInit ok! %s", bean.toString());
        } catch (BeansException ignored) {
            log.atInfo().log("The bean could not be created");
        }
    }

    @PreDestroy
    public void destroyMe(){
        log.atInfo().log("Destroy with annotation!!!");

    }

    @Override
    public void destroy() throws Exception {
        log.atInfo().log("Destroy with interface!!!");
    }
}
