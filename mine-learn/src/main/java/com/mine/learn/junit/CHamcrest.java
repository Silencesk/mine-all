package com.mine.learn.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CHamcrest {
	private static CHamcrest instance = null;
	
	private  CHamcrest(){
	}
	
	public static CHamcrest getInstance(){
		if(instance == null){
			instance = new CHamcrest();
		}
		return instance;
	}
	
	public int add(int a, int b){
		return (a + b);
	}
	
	public int divide(int a, int b){
		return (a / b);
	}
	
	public List<String> getList(String item){
		List<String> l = new ArrayList<String>();
		l.add(item);
		return l;
	}
	
	public Map<String, String> getMap(String key, String value){
		Map<String, String> m = new HashMap<String, String>();
		m.put(key, value);
		return m;
	}
}
