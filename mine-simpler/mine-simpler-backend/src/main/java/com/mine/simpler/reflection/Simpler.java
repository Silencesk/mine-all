package com.mine.simpler.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Simpler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//所有类的实例其实都是Class的实例
		Class<?> demo = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		
		try {
			demo = Class.forName("com.mine.simpler.reflection.Demo");	//通过反射得到class实例
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		demo2 = new Demo().getClass();	//通过类的实例对象获得class实例
		demo3 = Demo.class;	//直接得到class实例
		
		System.out.println("demo is " + demo);
		System.out.println("demo2 is "+ demo2);
		System.out.println("demo3 is "+ demo3);
		
		//类进行实例化
		Who who = null;
		try {
			who = (Who)Class.forName("com.mine.simpler.reflection.Who").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		who.setId("1");
		who.setName("who1");
		who.printStr();
		
		//获取类所有实现的接口
		Class<?>[] is = demo.getInterfaces();
		for(Class<?> i : is){
			System.out.println(i);
		}
		
		//获取所有方法
		Method[] ms = demo.getMethods();
		Demo obj;
		try {
			obj = (Demo) demo.newInstance();
		Object[] args1 = null;
		try {
			for(Method m : ms){
				System.out.println(m + " is invoking");
				if(m.getParameterTypes() != null && m.getParameterTypes().length>0){
					continue;
				}
				m.invoke(obj, args1);
				
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
