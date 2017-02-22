package com.mine.learn.junit;


import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class CHamcrestTest {
	private CHamcrest instance = CHamcrest.getInstance();
	
	@Test
	public void testAdd(){
		int a = 1, b = 2;
		int result = instance.add(a, b);
		assertThat(result, anyOf(is(4), lessThan(5)));
		assertThat(result, is(notNullValue()));	//只要一个断言为false，则后面的断言都不会执行
		assertThat(result, not(3));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetList(){
		List<String> result = instance.getList("hello");
		result.add("world");
		//将list转换为array
		String[] arryStr = {};
		arryStr = result.toArray(arryStr);
		for(String str : arryStr){
			System.out.println(str);
		}
		
		assertThat(result, Matchers.hasItems("world", "hello"));
		assertThat(result, Matchers.contains("hello", "world"));	//数组全匹配
		assertThat(result, Matchers.containsInAnyOrder("world", "hello"));	//数组匹配，忽略顺序
		assertThat(result, Matchers.hasItems(startsWith("wor"), endsWith("ld")));
		assertThat(new Integer[]{1,2,3}, is(array(equalTo(1), equalTo(2), equalTo(3))));
		assertThat(arryStr, is(array(equalTo("hello"), equalTo("world"))));
	}
}
