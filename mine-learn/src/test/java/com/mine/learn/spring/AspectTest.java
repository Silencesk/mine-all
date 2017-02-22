package com.mine.learn.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: 
 * author:      liutao
 * Createdate:  2016年8月13日下午4:29:52
 */

public class AspectTest {
	
	public static void main1(String[] args){
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	} 

}
