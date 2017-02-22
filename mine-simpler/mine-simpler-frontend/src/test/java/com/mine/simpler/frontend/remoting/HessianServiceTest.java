package com.mine.simpler.frontend.remoting;

import java.net.MalformedURLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caucho.hessian.client.HessianProxyFactory;
import com.mine.simpler.frontend.remoting.HelloService;

public class HessianServiceTest {
	@Test
	public void testHessianService(){
		String url = "http://localhost:8080/mine-simpler-frontend/hessian";
		HessianProxyFactory factory = new HessianProxyFactory();
		try {
			HelloService hello = (HelloService) factory.create(HelloService.class, url);
			System.out.println(hello.sayHello("world"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("resource")
	@Test
	public void testHessianService2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("hessian-client.xml");
		HelloService helloService = (HelloService) context.getBean("helloService");
		System.out.println(helloService.sayHello("world"));
		System.out.println(helloService.sayHello("kitty"));
	}
}
