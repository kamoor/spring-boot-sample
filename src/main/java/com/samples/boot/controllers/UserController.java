package com.samples.boot.controllers;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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
		logger.info("UserController constructed + " + key);
		
	}
	
	@Value("${external.key}")
	String key;
	
	
		
		
	
	/**
	 * Just a test controller to return user object.
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/users/{userId}")
	public  @ResponseBody User getUser(@RequestParam(value="userId", required=false, defaultValue="0") int userId) {
		  logger.debug("Get User by ID");
		  User user = new User();
		  user.setFirstName("Michelle");
		  user.setLastName("Obama");
		  return user; 
	}

	

}
