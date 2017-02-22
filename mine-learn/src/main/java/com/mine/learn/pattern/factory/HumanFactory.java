package com.mine.learn.pattern.factory;

import java.util.HashMap;
import java.util.Map;
/**
 * 带缓存的静态工厂方法
 * Description: 
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2015-10-3下午5:48:21
 *
 *
 * Modification  History:
 * Date         Author             What
 * ------------------------------------------
 * 2015-10-3     	liutao
 */
public class HumanFactory {
	public final static Map<String, Human> mans = new HashMap<String, Human>();	//同类人的缓存  
	
	public static Human createHuman(Class<?> clzz){
		Human man = null;
			try {
				man = (Human) Class.forName(clzz.getName()).newInstance();
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
			
		return man;
	}
	
	public static Human createHumanSingleton(Class<?> clzz){
		String key = clzz.getSimpleName();
		Human man = mans.get(key);
		if(man == null){
			try {
				man = (Human) Class.forName(clzz.getName()).newInstance();
				mans.put(key, man);
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
		}
		return man;
	}
}
