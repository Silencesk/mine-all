package com.mine.learn.concurrent;

public class MapOperationThread extends Thread {
	ConcurrentHashMap2<String, String> concurrentMap;
	String key;
	String value;
	
	public MapOperationThread(ConcurrentHashMap2<String, String> concurrentMap, String key, String value) {
		this.concurrentMap = concurrentMap;
		this.key = key;
		this.value = value;
	}

	@Override
	public void run(){
		System.out.println("线程[" + Thread.currentThread().getName() + "]开始启动....");
		
		System.out.println("线程[" + Thread.currentThread().getName() + "] get key " + concurrentMap.get(key));
		System.out.println("线程[" + Thread.currentThread().getName() + "] put key ....");
		concurrentMap.put(key, value);
		System.out.println("线程[" + Thread.currentThread().getName() + "] put key end....");
		
		System.out.println("线程[" + Thread.currentThread().getName() + "]已结束");
	}
}