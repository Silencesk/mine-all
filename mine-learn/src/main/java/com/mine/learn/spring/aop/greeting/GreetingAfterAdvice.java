/**
 * 
 */
package com.mine.learn.spring.aop.greeting;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * Description: 
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2016年3月26日下午5:50:47
 */

public class GreetingAfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("After...");
	}


}
