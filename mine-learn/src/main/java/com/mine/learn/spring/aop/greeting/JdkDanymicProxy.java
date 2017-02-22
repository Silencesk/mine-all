/**
 * 
 */
package com.mine.learn.spring.aop.greeting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description: 
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2016年3月26日下午2:34:55
 */

public class JdkDanymicProxy implements InvocationHandler {
	Object target;
	
	public JdkDanymicProxy(Object target){
		this.target = target; 
	}

	public Object getProxy(){
		return  Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
//		Object result = method.invoke(proxy, args);		//会循环调用代理类的invoke方法;
		Object result = method.invoke(target, args);	//所以只能传入target，相当于调用target的方法
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
