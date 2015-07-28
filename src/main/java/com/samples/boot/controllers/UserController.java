package com.samples.boot.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samples.boot.vo.User;



/**
 * User create,update, delete apis
 * @author kamoorr
 *
 */

@Controller
public class UserController {
	
	static Logger logger = Logger.getLogger(UserController.class);
	
	
	
	
	@PostConstruct
	public void postConstruct() {
		logger.info("UserController constructed ");
		
	}
	
		
		
	
	/**
	 * Just a test controller to return user object.
	 * @param userId
	 * @return
	 * @throws HttpMediaTypeNotSupportedException 
	 */
	@RequestMapping(value="/users/{userId}")
	public  @ResponseBody List<User> getUser(@RequestParam(value="userId", required=false, defaultValue="0") int userId) throws HttpMediaTypeNotSupportedException {
		 // logger.debug("Get User by ID");
		  
		  List<User> users = new ArrayList<User>();
		  for(int i=0;i<10000;i++){
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
	
	
	
	/**
	 * Just a test controller to write user object in to .
	 * @param userId
	 * @return
	 * @throws HttpMediaTypeNotSupportedException 
	 */
	@RequestMapping(value="/serialize/{userId}")
	public  @ResponseBody List<User>  serializedUser(@RequestParam(value="userId", required=false, defaultValue="0") int userId) throws HttpMediaTypeNotSupportedException {
		List<User> users = this.getUser(userId);
		try {
			  FileOutputStream fout = new FileOutputStream("/tmp/users.obj");
			  ObjectOutputStream oos = new ObjectOutputStream(fout);
			  oos.writeObject(users);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return users;
	}

}
