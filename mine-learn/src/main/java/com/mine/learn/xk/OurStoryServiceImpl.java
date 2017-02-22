package com.mine.learn.xk;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * Description: 
 * author:      liutao
 * Createdate:  2016年8月13日下午4:39:28
 */
@Component
@OurStoryAnnotation
public class OurStoryServiceImpl implements OurStoryService{
	private String xk = "xk: ";
	private String lt = " :lt";
	
	@Override
	public void firstChat() {
//		System.out.println("xk同学，你好^_^" + lt);
//		System.out.println(xk + "你好");
//		System.out.println("先做下自我介绍哈，我是lt，湖南邵阳人，"
//				+ "90年，目前在深圳的一家软件公司上班，软件工程师。很高兴认识你。" + lt);
//		System.out.println(xk + "呃。你们一般都是这么讲话的");
		
		/*proxy.print(lt, "徐可同学，你好^_^");
		proxy.print(xk, "你好");
		proxy.print(lt, "先做下自我介绍哈，我是lt，湖南邵阳人，"
				+ "90年，目前在深圳的一家软件公司上班，软件工程师。很高兴认识你。");
		proxy.print(xk, "呃。你们一般都是这么讲话的");*/
		
		OurStoryServiceImpl proxy = (OurStoryServiceImpl)AopContext.currentProxy();
		proxy.print(lt, "xk同学，你好^_^");
		proxy.print(xk, "你好");
		proxy.print(lt, "先做下自我介绍哈，我是lt，湖南邵阳人，"
				+ "90年，目前在深圳的一家软件公司上班，软件工程师。很高兴认识你。");
		proxy.print(xk, "呃。你们一般都是这么讲话的");
	}
	
	public void print(String who, String content){
		if(who.equals(xk)){
			System.out.println(xk + content);
		}else{
			System.out.println(content + lt);
		}
	}
	
}
