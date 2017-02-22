package com.mine.learn.test;

/**
 * Description: 
 * author:      liutao
 * Createdate:  2016年4月23日下午11:05:28
 */

public class Son extends Parent{
	@Override
	protected void protectedMethod(){
		System.out.println(">>>>Son protectedMethod invoke<<<<");
		privateMethod();
	}
}
