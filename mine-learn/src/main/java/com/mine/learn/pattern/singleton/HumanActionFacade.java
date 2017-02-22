package com.mine.learn.pattern.singleton;

import com.mine.learn.pattern.factory.Human;

/**
 * 
 * Description: 人类复杂行为的工具类
 * 
 */
public class HumanActionFacade {
	private Human man = null;
	
	public HumanActionFacade(Human man){
		this.man = man;
	}
	
	public void doSomething(){
		man.talk();
		man.reading();
		man.walk();
	}
}
