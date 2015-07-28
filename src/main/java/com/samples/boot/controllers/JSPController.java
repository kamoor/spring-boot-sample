package com.samples.boot.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.samples.boot.vo.User;



/**
 * User create,update, delete apis
 * @author kamoorr
 *
 */

@Controller
public class JSPController {
	
	static Logger logger = Logger.getLogger(JSPController.class);
	
	
	
	/**
	 * In spring-context.xml org.springframework.web.servlet.view.InternalResourceViewResolver is configured to use 
	 * prefix jsp
	 * suffix .jsp
	 * 
	 * @param request
	 * @return
	 */
	
	@RequestMapping("/helloworld1")
	public ModelAndView defaultAdminRequest(final HttpServletRequest request) {
		logger.info("helloworld1 request");
		return  new ModelAndView("helloworld");
	}
	

}
