package com.mine.learn.pattern.facade;

public class Client {

	public static void main1(String[] args) {
		//1.非门面模式的信件投放
		LetterProcess letterProcess = new LetterProcessImpl();
		System.out.println("====普通实现-start====");
		letterProcess.write("我喜欢你");
		letterProcess.pack();
		letterProcess.post("freedom of paridise");
		System.out.println("====普通实现-end====");
		
		//2.使用门面模式
		String content = "我喜欢你";
		String address = "freedom of paridise";
		LetterProcessFacade letterProcessFacade = new LetterProcessFacade(letterProcess);
		System.out.println("====门面模式实现-start====");
		letterProcessFacade.postLetter(content, address);
		System.out.println("====门面模式实现-end====");
	}

}
