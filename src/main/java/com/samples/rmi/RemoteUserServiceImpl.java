package com.samples.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.samples.boot.vo.User;

/**
 * This is a service exposed through Spring remoting
 * @author kamoorr
 *
 */
@Component("remoteUserServiceImpl")
public class RemoteUserServiceImpl implements RemoteUserService {

	/**
	 * Just returning few list of objects. Using random string to mimic actual data 
	 */
	@Override
	public List<User> getUser(int userId) throws RemoteException {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10000; i++) {
			User user = new User();
			user.setFirstName(String.valueOf(i * 145));
			user.setLastName(String.valueOf(i * 300));
			user.setUserId(i);
			user.setEmail(String.valueOf(i * 10000));
			user.setPhone(String.valueOf(i * 55));
			users.add(user);
		}
		return users;
	}

}
