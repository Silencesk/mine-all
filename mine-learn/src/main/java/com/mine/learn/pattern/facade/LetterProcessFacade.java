package com.mine.learn.pattern.facade;

public class LetterProcessFacade {
	private LetterProcess lp;
	
	public LetterProcessFacade(LetterProcess lp){
		this.lp = lp;
	}
	
	public void postLetter(String content, String address){
		lp.write(content);
		lp.pack();
		lp.post(address);
	}
}
