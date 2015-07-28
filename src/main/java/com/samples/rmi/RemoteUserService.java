package com.samples.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.samples.boot.vo.User;

public interface RemoteUserService extends Remote {
	
	
	 public List<User> getUser(int userId)throws RemoteException;
}
