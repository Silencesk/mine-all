package com.mine.learn.spring.aop;
/**
 * 
 * Description: 猴子偷桃类（普通类）
 * 引用一个猴子偷桃，守护者守护果园抓住猴子的小情节。 
 * 
 */
public class Monkey {
	public void stealPeaches(String name){
		System.out.println("猴子【"+name+"】正在偷桃。。。。");
	}
}
