package com.mine.learn.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap2<K,V> extends ConcurrentHashMap<K,V>{
	private static final long serialVersionUID = 1L;

	@Override
	public V put(K key, V value) {
		V retObj = super.put(key, value);
		
		try {
			System.out.println("线程[" + Thread.currentThread().getName() + "] sleep....");
			Thread.sleep(10);
			System.out.println("线程[" + Thread.currentThread().getName() + "] sleep end....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return retObj;
	}
}