package com.lewis.bohconfig.common.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by zhangminghua on 2017/1/9.
 */
@Component
public class AppContext implements ApplicationContextAware {

    private static ApplicationContext context;

    public synchronized void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    public synchronized static ApplicationContext getApplicationContext() {
        return context;
    }
}
