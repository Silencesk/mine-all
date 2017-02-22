package com.mine.learn.test;

/**
 * Description: 
 * author:      liutao
 * Createdate:  2016年4月23日下午11:03:04
 */

public class Parent {
	protected void protectedMethod(){
		System.out.println(">>>>Parent protectedMethod invoke<<<<");
		privateMethod();
	}
	protected void privateMethod(){
		System.out.println(">>>>Parent privateMethod invoke<<<<");
	}
}
