package com.mine.learn.concurrent;

public class ConcurrentHashMapTest {
	static ConcurrentHashMap2<String, String> concurrentMap = new ConcurrentHashMap2<String, String>();
	
	public static void main(String[] args){
		String key = "one";
		concurrentMap.put(key, "one");
		
		MapOperationThread t1 = new MapOperationThread(concurrentMap, key, "t1");
		MapOperationThread t2 = new MapOperationThread(concurrentMap, key, "t2");
		
		t1.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
	}
	
	
}
