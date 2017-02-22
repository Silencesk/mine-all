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

public class RMIServer {
	private static Logger logger = LoggerFactory.getLogger(RMIServer.class);
	
	@Test
	public void testRmiServerStart(){
		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry();
			System.out.println(registry.list().toString());
		} catch (RemoteException e) {
			int port = 1099;
			try {
				registry = LocateRegistry.createRegistry(port);
			} catch (RemoteException e1) {
				logger.error(e1.getMessage());
				Assert.assertTrue(false);
			}
		}
		try {
			RHello hello = new RHelloImpl();
			registry.rebind("hello", hello);
			logger.info(">>>RMIServer has started...");
			Assert.assertTrue(true);
			Thread.sleep(3000000L);	// 客户端访问的时候，服务端的服务必须启动
			logger.info(">>>RMIServer has ended...");
			
		} catch (Exception e) {
			logger.info(">>>RMIServer failed..." + e);
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * 单元测试方法与main方法不同，单元测试的线程只要执行代码后程序便会结束，如若让程序维持运行，则必须sleep当前线程；
	 * 但main方法中RMIRegistry启动后便会一直执行，除非手动停止；
	 * 客户端只是一次的调用，单元测试方法与main方法运行的效果是一致的
	 */
	public static void main(String[] args){
		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry();
			System.out.println(registry.list().toString());
		} catch (RemoteException e) {
			int port = 1099;
			try {
				registry = LocateRegistry.createRegistry(port);
			} catch (RemoteException e1) {
				logger.error(e1.getMessage());
				Assert.assertTrue(false);
			}
		}
		try {
			RHello hello = new RHelloImpl();
			registry.rebind("RHello", hello);
			logger.info(">>>RMIServer has started...");
			//Thread.sleep(3000000L);	// 客户端访问的时候，服务端的服务必须启动
			logger.info(">>>RMIServer has ended...");
			
		} catch (Exception e) {
			logger.info(">>>RMIServer failed..." + e);
			Assert.assertTrue(false);
		}
	}
	
	@SuppressWarnings({ "unused", "resource" })
	@Test
	public void testSpringRmiServer() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:rmi-server.xml");
		logger.info("RMI服务伴随Spring的启动而启动了.....");
		Assert.assertTrue(true);
		Thread.sleep(3000000L);
	}
}
