package com.mine.learn;

public class ObjectStd {
	
	private void privateMethod(){
		System.out.println("测试私有方法是否可在main方法里头运行");
	}
	
	public static void main1(String[] args) {
		ObjectStd obj = new ObjectStd();
		obj.privateMethod();
		String result = "相信书本所说，不要被忽悠了，有些题目是陷阱";
		System.out.println(result);
	}

}
