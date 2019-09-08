package com.example.lifecycle;

import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Flogger
@Component
public class InitializingBeanAware implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.atInfo().log("InitializingBeanAware.afterPropertiesSet() is called!");
    }
}
