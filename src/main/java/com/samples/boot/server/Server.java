package com.samples.boot.server;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring boot to start server on the fly and run an app. Parameters: --debug to
 * start in debug mode
 * 
 * @author kamoorr
 * 
 */
@EnableAutoConfiguration
@ComponentScan
@EnableCaching
@ImportResource(value = { "classpath:spring/*.xml" })
public class Server {

	public static void main(String[] args) {
		System.out.println("Start Spring Application: nube-api-idm");
		ApplicationContext ctx = SpringApplication.run(Server.class, args);
	}

	@Bean
	public ServerProperties getServerProperties() {
		return new NubeServerCustomization();
	}
	
	
	@Bean(name="cacheManager")
	public CacheManager cacheManager() {
	    SimpleCacheManager cacheManager = new SimpleCacheManager();
	    cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("content")));

	    return cacheManager;
	}




}
