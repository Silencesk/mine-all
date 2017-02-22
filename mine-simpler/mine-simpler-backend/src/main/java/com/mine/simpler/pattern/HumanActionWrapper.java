package com.mine.simpler.pattern;
/**
 * 
 * Description: 人类公共行为的封装处理
 * 
 */
public class HumanActionWrapper {
	public static void doSomething(Human man){
		man.talk();
		man.reading();
		man.walk();
	}
}
