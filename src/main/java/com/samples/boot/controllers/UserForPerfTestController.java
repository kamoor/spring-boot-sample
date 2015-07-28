package com.samples.boot.controllers;

import java.rmi.RemoteException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.samples.boot.vo.User;
import com.samples.rmi.RemoteUserService;

/**
 * Creating this to run a perf test Compare Spring Rest - Vs - Spring Remoting
 * 
 * @author kamoorr
 *
 */
@Controller
public class UserForPerfTestController {

	static Logger logger = Logger.getLogger(UserForPerfTestController.class);

	RestTemplate restTemplate;

	String baseUrl;

	@Value("${server.port}")
	int port;

	@Autowired()
	@Qualifier("userServiceClient")
	RemoteUserService remoteUserService;

	@PostConstruct
	public void UserForPerfTestController() {

		restTemplate = new RestTemplate();
		baseUrl = String.format("http://localhost:%d/users/100",
				port);
	}

	/**
	 * A rest call to another service,
	 * 
	 * @return
	 */
	@RequestMapping(value = "/perf/rest")
	public @ResponseBody List<User> ServiceByRest() {
		// logger.info("Request ");
		List<User> users = restTemplate.getForObject(baseUrl, List.class);
		return users;
	}

	/**
	 * A spring remoting (RMI) call
	 * 
	 * @return
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/perf/remoting")
	public @ResponseBody List<User> ServiceByRemoting() throws RemoteException {
		// logger.info("Request ");
		List<User> users = remoteUserService.getUser(100);
		return users;
	}

}
