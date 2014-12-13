package com.samples.boot.cache;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class  CachedClass {

	static Logger log = Logger.getLogger(CachedClass.class);

	
	@Cacheable(value="content")
	public Map<String, String> getContent(){
	    log.info("Retrieving content with out cache>>>>>>>>>>>>>>>>>>>>");
	    Map<String, String> content = new HashMap<String, String>();
	    content.put("ee", "ss");
	    return content;
	}
}
