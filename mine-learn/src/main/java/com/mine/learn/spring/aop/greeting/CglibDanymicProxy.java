/**
 * 
 */
package com.mine.learn.spring.aop.greeting;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Description: 
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2016年3月26日下午3:26:15
 */

public class CglibDanymicProxy implements MethodInterceptor {
	private static CglibDanymicProxy instance = new  CglibDanymicProxy();
	
	public static CglibDanymicProxy getInstance(){
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> calzz){
		return (T) Enhancer.create(calzz, this);
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		before();
		// cglib的代理方法,保存了目标对象的信息,提供了调用目标对象方法的invokeSuper,
		Object result = methodProxy.invokeSuper(proxy, args);
		// 这种方式便会循环调用代理类自身的方法了
//		Object result = methodProxy.invoke(proxy, args);
		// 这种方式也是,其实际都是代理对象在调用自身的方法
//		Object result = method.invoke(proxy, args);
		after();
		return result;
	}
	
	public void before(){
		System.out.println("Before....");
	}
	
	public void after(){
		System.out.println("After....");
	}
}
