package com.mine.simpler.frontend.remoting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService {
	private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

	@Override
	public String sayHello(String name) {
		String msg = "hello " + name;
		logger.debug(msg);
		return msg;
	}

}
