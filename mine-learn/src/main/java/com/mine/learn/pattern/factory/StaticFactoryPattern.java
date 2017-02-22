package com.mine.learn.pattern.factory;

import java.util.List;
import java.util.Random;

import com.mine.core.util.ClassUtils;
import com.mine.learn.pattern.singleton.HumanActionFacade;

/**
 * 
 * Description: 静态工厂设计模式
 * All rights Reserved, Designed By mine
 * Copyright:   Copyright(C) 2014-2015
 * Company:     mine.
 * author:      liutao
 * Createdate:  2015-9-29上午8:41:46
 *
 *
 * Modification  History:
 * Date         Author             What
 * ------------------------------------------
 * 2015-9-29     	liutao
 */
public class StaticFactoryPattern {
	public static void main1(String[] args){
		//获取准确的人
		getExactPerson();
		//随机获取人类
		getRandomPerson();
	}
	
	private static void getExactPerson(){
		System.out.println("-----getExactPerson-start-----");
		WhiteHuman wman = (WhiteHuman)HumanFactory.createHuman(WhiteHuman.class);
		HumanActionUtil.doSomething(wman);
		
		YellowHuman yman = (YellowHuman)HumanFactory.createHuman(YellowHuman.class);
		//静态工具类方法实现包装
		HumanActionUtil.doSomething(yman);
		//使用门面模式的封装
		HumanActionFacade humanFacade= new HumanActionFacade(yman);
		humanFacade.doSomething();
		System.out.println("-----getExactPerson-end-----");
	}
	
	@SuppressWarnings("rawtypes")
	private static void getRandomPerson(){
		System.out.println("-----getRandomPerson-start-----");
		List<Class> humanClasses = ClassUtils.getAllClassesByInterface(Human.class);
		
		if(humanClasses!=null && humanClasses.size()!=0){
			int size = humanClasses.size();
			Random rand = new Random();	//Random(seed) 同一seed生成的随机数是一致的 
			for(int i=0; i<2; i++){
				int index = rand.nextInt(size);
				Human man = HumanFactory.createHuman(humanClasses.get(index));
				//静态工具类实现多业务的包装
				HumanActionUtil.doSomething(man);
				//使用门面模式的封装
				HumanActionFacade humanFacade= new HumanActionFacade(man);
				humanFacade.doSomething();
				
			}
		}
		
		System.out.println("-----getRandomPerson-end-----");
	}
	
}
