package com.mine.learn.thread;
/**
 * ThreadLocal 线程内的共享变量
 * Description: 
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2015年10月17日下午3:29:58
 *
 *
 * Modification  History:
 * Date         Author             What
 * ------------------------------------------
 * 2015年10月17日     	liutao
 */
public class TestNum {
	//线程安全  
	ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue(){
			return 0;
		}
	};
	
	public Integer getNextNum(){
		num.set(num.get()+1);
		return num.get();
	}
	
	public static void main1(String[] args){
		TestNum sn = new TestNum();
		Thread[] runs = new TestClient[3];
		//各线程共用的TestNum互不影响
		for(Thread client : runs){
			client = new TestClient(sn);
			client.start();
		}
	}
}
