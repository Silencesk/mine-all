package com.mine.learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapStd {
	public static void main1(String[] args){
		Map<String, String> map = new HashMap<String, String>();
		map.put("str1", "1");
		map.put("str2", "2");
		map.put("str3", "3");
		
		//one
		System.out.println("通过map.keySet()分别读取key value");
		for(String key : map.keySet()){
			System.out.println("keySet[key:" + key + "; value:" + map.get(key) + "]");
		}
		
		//two
		System.out.println("通过map.entrySet()的iterator读取key value");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.println("entrySet-iterator[key:" + entry.getKey() + "; value:" + entry.getValue() + "]");
		}
		
		//three  best
		System.out.println("通过map.entrySet()的foreach读取key value");
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println("entrySet-foreach[key:" + entry.getKey() + "; value:" + entry.getValue() + "]");
		}
		
		//four
		System.out.println("通过map.values()遍历value，无法获取key");
		for(String value : map.values()){
			System.out.println("values[value:" + value + "]");
		}
		
	}
}
