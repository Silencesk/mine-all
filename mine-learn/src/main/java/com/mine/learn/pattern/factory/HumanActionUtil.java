package com.mine.learn.pattern.factory;
/**
 * 
 * Description: 人类复杂行为的工具类
 * 
 */
public class HumanActionUtil {
	public static void doSomething(Human man){
		man.talk();
		man.reading();
		man.walk();
	}
}
