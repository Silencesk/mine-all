package com.mine.learn.spring;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mine.learn.thread.MapAndListDITestThread;

public class SpringDependencyInjectionTest {
	
	public static void main1(String[] args){
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		MapAndListDITestThread t = new MapAndListDITestThread();
		t.setFactory(factory);
		MapAndListDITestThread t1 = new MapAndListDITestThread();
		t1.setFactory(factory);
		//t线程开始执行
		System.out.println("thread t start-----");
		t.start();
		//t线程执行完main才继续执行
		try {
			t.join();	//将线程t加入至主线程内执行
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*while(true){
			if(t.getState().equals(Thread.State.TERMINATED)){
				break;
			}
		}*/
		System.out.println("\nthread t1 start-----");
		//t1开始执行
		t1.start();
		//t1线程执行完main才继续执行
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*while(true){
			if(t1.getState().equals(Thread.State.TERMINATED)){
				break;
			}
		}*/
		System.out.println("\n----Thread.activeCount()----" + Thread.activeCount());
		System.out.println("----Thread.currentThread()----" + Thread.currentThread());
		System.out.println("----Thread.getAllStackTraces()----" + Thread.getAllStackTraces());
	}
}
