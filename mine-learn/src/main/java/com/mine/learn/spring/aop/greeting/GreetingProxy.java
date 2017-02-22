/**
 * 
 */
package com.mine.learn.spring.aop.greeting;

/**
 * Description: 
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2016年3月26日上午11:37:27
 */

public class GreetingProxy implements Greeting{
	private Greeting greet;
	
	public GreetingProxy(Greeting greet){
		this.greet = greet;
	}

	@Override
	public void sayHello(String name) {
		before();
		greet.sayHello(name);
		after();
	}
	
	public void before(){
		System.out.println("Before....");
	}
	
	public void after(){
		System.out.println("After....");
	}
	
}
