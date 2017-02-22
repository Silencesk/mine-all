package com.mine.learn.pattern.facade;

public class LetterProcessImpl implements LetterProcess {

	@Override
	public void write(String content) {
		// TODO write
		System.out.println("开始写信：" + content);
	}

	@Override
	public void pack() {
		// TODO pack
		System.out.println("信件包装");
	}

	@Override
	public void post(String address) {
		// TODO post
		System.out.println("信件投放，投放地址：" + address);
	}

}
