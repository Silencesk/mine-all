package com.mine.simpler.frontend.remoting;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RHelloImpl extends UnicastRemoteObject implements RHello{
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
	
	public RHelloImpl() throws RemoteException{
		super();
	}

	@Override
	public String sayHello(String name) throws RemoteException{
		String msg = "hello " + name;
		logger.debug(msg);
		return msg;
	}	
}
