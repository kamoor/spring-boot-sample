package com.samples.boot.server;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * Spring boot to start server on the fly and run an app.
 * Parameters:
 * --debug to start in debug mode
 *    
 * @author kamoorr
 * 
 */
//@Configuration
@EnableAutoConfiguration
@ComponentScan
//@PropertySource("classpath:log4j.properties")
@ImportResource(value = { "classpath:spring/*.xml" })
public class Server {
	
	
	

	public static void main(String[] args) {
		System.out.println("Start Spring Application: nube-api-idm");
		ApplicationContext ctx = SpringApplication.run(Server.class, args);
		//printBeans(ctx);
		//JVMStatus.printJVMStatus();
	}

	/**
	 * Print all the beans
	 * @param ctx
	 */
	private static void printBeans(ApplicationContext ctx) {
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
				System.out.println("Bean Found: " + beanName);
			
		}
	}
	/**
	 * Define a server. Using tomcat or jetty will be out of the box
	 * 
	 * @return
	 */
	// @Bean
	// public EmbeddedServletContainerFactory servletContainer() {
	// System.out.println("Reconfiguring servlet container to tomcat");
	// TomcatEmbeddedServletContainerFactory factory = new
	// TomcatEmbeddedServletContainerFactory();
	// factory.setPort(9000);
	// factory.setBaseDirectory(new File("target")); // look for work folder
	// factory.setContextPath("/api");
	//
	// factory.setSessionTimeout(30, TimeUnit.MINUTES);
	// factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
	// "/error_404.html"));
	//
	// //System.out.println("Base path"+ factory.getB.getAbsolutePath());
	//
	// return factory;
	// }

}
