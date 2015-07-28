package com.samples.boot.server;


import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
public class ResourceRefresher {
	
	static Logger logger = Logger.getLogger(ResourceRefresher.class);
	
	@PostConstruct
	public void postConstruct(){
		logger.info("batch config");
	}
	
	@Autowired
	ConfigurableApplicationContext context;
	
	

	@Scheduled(fixedRate = 600000)
	public void scheduled(){
		
		//logger.info("sample scheduler test,  properties ");
	}
	
	
	

}
