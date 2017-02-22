package com.mine.learn.pattern.facade;
/**
 * 
 * Description: 门面模式模拟场景
 * 定义一个写信的接口LetterProcess，以及其实现类LetterProcessImpl，模拟信件流程，; 
 * 写信的人需完成调用写信过程的实现类;
 * 1）在未使用门面设计模式时，写信人需关心写信流程；包括写信-包装-投递
 * 2）使用后，增加信件流程服务类，ModernPostOffice，写信人只需调用该类提供的方式postLetter即可，具体细节由ModernPostOffice.postLetter实现
 * 
 */
public interface LetterProcess {
	public void write(String content);
	public void pack();
	public void post(String address);
}
