/**
 * 
 */
package com.mine.learn.spring.aop.greeting;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Description: 
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2016年3月26日上午11:28:41
 */

public class Client {
	
	/**
	 * invocation1:在sayHello中夹杂了其他职责
	 * @param args
	 */
	public static void main1(String[] args) {
		String name = "world";
		Greeting greet = new GreetingImpl();
		greet.sayHello(name);
	}
	/**
	 * invocation2:静态代理模式,新建一个代理类,将before,after的逻辑置于其中,
	 * 让greet类职责单一
	 * @param args
	 */
	public static void main2(String[] args) {
		String name = "world";
		GreetingProxy greetProxy = new GreetingProxy(new GreetingImpl());
		greetProxy.sayHello(name);
	}
	/**
	 * invocation3:jdk动态代理
	 * 所有的代理类都合并到动态代理类中,但只能代理接口
	 * @param args
	 */
	public static void main3(String[] args) {
		String name = "world";
		Greeting greeting = new GreetingImpl();
		Greeting greetProxy = (Greeting)new JdkDanymicProxy(greeting).getProxy();
		greetProxy.sayHello(name);
	}
	/**
	 * invocation4:cglib动态代理
	 * 可以代理实现类,无需接口
	 * @param args
	 */
	public static void main4(String[] args) {
		String name = "world";
		Greeting greetProxy = (Greeting)CglibDanymicProxy.getInstance().getProxy(GreetingImpl.class);
		greetProxy.sayHello(name);
	}
	/**
	 * invocation5:spring aop
	 * 编程实现,通过自定义beforeAdvice与afterAdvice;并将其设置到代理类中,可实现before,after功能
	 * @param args
	 */
	public static void main5(String[] args) {
		String name = "world";
		ProxyFactory proxyFactory= new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());
		proxyFactory.addAdvice(new GreetingBeforeAdvice());
		proxyFactory.addAdvice(new GreetingAfterAdvice());
		
		Greeting greetProxy = (Greeting)proxyFactory.getProxy();
		greetProxy.sayHello(name);
	}
}
