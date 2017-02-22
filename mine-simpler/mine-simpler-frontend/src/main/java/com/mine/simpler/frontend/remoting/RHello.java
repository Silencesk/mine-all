package com.mine.simpler.frontend.remoting;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RHello extends Remote {
	public String sayHello(String name) throws RemoteException;
}
