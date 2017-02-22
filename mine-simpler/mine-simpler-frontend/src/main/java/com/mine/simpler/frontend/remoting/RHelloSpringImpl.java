package com.mine.simpler.frontend.remoting;

import java.rmi.RemoteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Description: 接口类需extens remote 接口，实现类无需继承至UnicastRemoteObject
 * 
 */
public class RHelloSpringImpl implements RHello{	
	private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
	
	public RHelloSpringImpl() throws RemoteException{
		super();
	}

	@Override
	public String sayHello(String name) throws RemoteException{
		String msg = "hello " + name;
		logger.debug(msg);
		return msg;
	}
}
