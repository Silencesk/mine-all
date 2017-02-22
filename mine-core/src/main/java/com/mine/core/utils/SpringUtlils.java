package com.mine.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * 系统spring对象获取工具
 * 
 */
public class SpringUtlils implements ApplicationContextAware {
    private static ApplicationContext context;
    
	public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public void setApplicationContext(ApplicationContext cxt)
            throws BeansException {
        context = cxt;
    }
}
