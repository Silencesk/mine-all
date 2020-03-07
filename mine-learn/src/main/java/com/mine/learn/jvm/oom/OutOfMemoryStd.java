package com.mine.learn.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Description: 内存溢出示例
 * @see http://www.iteye.com/topic/1112423
 * @see http://blog.csdn.net/lzw190/article/details/10563757
 * author:      mokeo
 * Createdate:  2016年9月3日下午2:28:37
 */
public class OutOfMemoryStd {
	
	public static void main1(String[] args){
//		oom1();
		oom2();
	}
	
	/**
	 * out of memory (Permanent Generation space && PermGen space)
	 * -XX:MaxPermSize=8M
	 */
	public static void oom1(){
		// 使用list保持着常量池的引用，压制full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		
		// 10M的PermSize在integer范围内足够产生OOM了
		int i = 0;
		while(true){
			System.out.println("current i = " + i);
			// String#intern 将当前字符串放入常量池中 存储区域为PermGen space
			// http://tech.meituan.com/in_depth_understanding_string_intern.html
			list.add(String.valueOf("number ==> " + i++).intern());
		}
	}
	
	/**
	 * out of memory (java heap space)
	 * -Xms80m -Xmx100m
	 */
	public static void oom2(){
		List<String> list = new ArrayList<String>();
		
		int i = 0;
		while(true){
			System.out.println("current i = " + i);
			list.add("test" + i++);
		}
	}
	
	
}
