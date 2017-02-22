package com.mine.learn.concurrent;

public class ConcurrentHashMapTest {
	static com.mine.learn.concurrent.ConcurrentHashMap2<String, String> concurrentMap = new com.mine.learn.concurrent.ConcurrentHashMap2<String, String>();
	
	public static void main1(String[] args){
		String key = "one";
		concurrentMap.put(key, "one");
		
		com.mine.learn.concurrent.MapOperationThread t1 = new com.mine.learn.concurrent.MapOperationThread(concurrentMap, key, "t1");
		com.mine.learn.concurrent.MapOperationThread t2 = new com.mine.learn.concurrent.MapOperationThread(concurrentMap, key, "t2");
		
		t1.start();
		
		/*try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		t2.start();
	}
	
	
}
