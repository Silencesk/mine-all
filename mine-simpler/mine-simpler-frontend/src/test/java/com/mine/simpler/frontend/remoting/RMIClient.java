package com.mine.simpler.frontend.remoting;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RMIClient {
	private static Logger logger = LoggerFactory.getLogger(RMIClient.class);
	
	@Test
	public void testRMIClient(){
		String host = "localhost";
		int port = 1099;
		try {
			Registry registry = LocateRegistry.getRegistry(host, port);
			RHello helloStub = (RHello) registry.lookup("RHello");
			System.out.println(helloStub.sayHello("world"));
		} catch (Exception e) {
			System.out.println("RMI失败: " + e);
			Assert.assertTrue(false);
		}
	}
	
	public static void main(String[] args){
		String host = "localhost";
		int port = 1099;
		try {
			Registry registry = LocateRegistry.getRegistry(host, port);
			RHello helloStub = (RHello) registry.lookup("RHello");
			System.out.println(helloStub.sayHello("world"));
		} catch (Exception e) {
			System.out.println("RMI失败: " + e);
			Assert.assertTrue(false);
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void testSpringRmiClient(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:rmi-client.xml");
		RHello hello = (RHello) context.getBean("helloService");
		try {
			logger.info(hello.sayHello("world"));
			Assert.assertTrue(true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
