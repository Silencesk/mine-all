package com.mine.learn.pattern.singleton;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

public class SingletonBeanRegister implements SingletonBeanRegistry {
	//非线程安全
	private final Map<String, Object> BEANS = new HashMap<String, Object>();
	private final String[] BEAN_NAMES = {};	//相当于new String[0]

	public void registerSingleton(String beanName, Object singletonObject) {
		// TODO registerSingleton
		if(BEANS.containsKey(beanName)){
			throw new RuntimeException("bean[" + beanName + "]已经存在");
		}
		BEANS.put(beanName, singletonObject);
	}

	public Object getSingleton(String beanName) {
		// TODO getSingleton
		return BEANS.get(beanName);
	}

	public boolean containsSingleton(String beanName) {
		// TODO containsSingleton
		return BEANS.containsKey(beanName);
	}

	public String[] getSingletonNames() {
		// TODO getSingletonNames
		return BEANS.keySet().toArray(BEAN_NAMES);
	}

	public int getSingletonCount() {
		// TODO getSingletonCount
		return BEANS.size();
	}

	public Object getSingletonMutex() {
		// TODO getSingletonMutex
		return null;
	}

}
