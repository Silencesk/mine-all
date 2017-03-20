package com.mine.learn.xk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy=true)
public class OurStory{

    public static void main(String[] args) {
    	ApplicationContext ctx = SpringApplication.run(OurStory.class, args);
    }

}