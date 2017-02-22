package com.mine.learn.xk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class OurStory{
	
    public static void main1(String[] args) {
    	ApplicationContext ctx = SpringApplication.run(OurStory.class, args);
    	OurStoryService service = ctx.getBean(OurStoryService.class);
    	service.firstChat();
    }

}