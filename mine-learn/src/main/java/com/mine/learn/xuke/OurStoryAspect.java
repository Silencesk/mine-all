package com.mine.learn.xuke;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Description: 
 * author:      liutao
 * Createdate:  2016年8月13日下午4:39:28
 */
@Aspect
@Component
public class OurStoryAspect{
	@Pointcut("@target(com.mine.learn.xuke.OurStoryAnnotation)")
	public void targetPointCut(){};
	
	@Pointcut("execution(* firstChat())")
	public void firstChatPointCut(){};
	
	@Around(value = "targetPointCut() && firstChatPointCut()")
	public void firstChatAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("-------our first chat 2016-05-16 begin------");
		pjp.proceed();
		System.out.println("-------our first chat 2016-05-16 end------");
	}
	
	@Pointcut("execution(* print())")
	public void printPointCut(){};
	
	@After(value = "targetPointCut() && printPointCut()")
	public void printAdvice(JoinPoint pjp) throws Throwable{
		System.out.println();
	}
}
