package com.mine.learn.pattern.singleton;

/**
 * Description: 惰性初始化的单例设计模式  
 * Java中静态内部类可以访问其外部类的成员属性和方法，
 * 同时，静态内部类只有当被调用的时候才开始首次被加载，
 * 利用此特性，可以实现懒汉式，在静态内部类中静态初始化外部类的单一实例即可
 * 线程安全
 * 静态内部类&&静态代码块，都是在这个类第一次被调用或实例化的时候就会被执行。
 */
public class Singleton {
	//定义私有方法 不能通过默认的构造器获取对象
	private Singleton(){};
	//定义静态内部类，持有对象instance，单例缓存者，实现惰性初始化，第一次使用的时候初始化
	public static class SingletnHolder{
		public static final  Singleton INSTANCE = new Singleton();
	}
	//提供获取单例的全局访问点
	public static Singleton getInstance(){
		return SingletnHolder.INSTANCE;
	}
	
	public static void main1(String[] args){
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2);
	}
}
