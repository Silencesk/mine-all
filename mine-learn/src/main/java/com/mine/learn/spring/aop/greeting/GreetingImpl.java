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
 * Createdate:  2016年3月26日上午11:25:35
 */

public class GreetingImpl implements Greeting {
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
	
	public void sayHello1(String name) {
		before();
		System.out.println("Hello " + name);
		after();
	}
	
	public void before(){
		System.out.println("Before....");
	}
	
	public void after(){
		System.out.println("After....");
	}
}
