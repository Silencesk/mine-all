package com.mine.simpler.reflection;

public class Demo implements iDemo, iDemo2{

	@Override
	public void test() {
		System.out.println("test invoke");
	}
	
}
