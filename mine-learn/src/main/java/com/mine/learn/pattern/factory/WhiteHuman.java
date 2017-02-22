package com.mine.learn.pattern.factory;

import com.mine.learn.pattern.factory.Human;

public class WhiteHuman implements Human{
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("white man talking!");
	}
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("white man walking!");
	}
	@Override
	public void reading() {
		// TODO Auto-generated method stub
		System.out.println("white man reading!");
	}

}
