package com.mine.learn.generics;

public class Box<T> {
	private T t;
	
	public T get(){
		return t;
	}
	
	public void add(T t){
		this.t = t;
	}
	
	public static void main1(String[] args){
		Box<Integer> intBox = new Box<Integer>();
		Box<String> strBox = new Box<String>();
		
		intBox.add(new Integer(10));
		strBox.add("Hello World");
		
		System.out.println("Box<Integer> t: " + intBox.get());
		System.out.println("Box<String> t: " + strBox.get());
	}
}
