package com.samples.boot.cache;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCache {
	
	@Autowired
	CachedClass  cachedCalss;
	
	@PostConstruct
	public void test(){
		///This code should execute  method only once
		cachedCalss.getContent();
		cachedCalss.getContent();
		cachedCalss.getContent();
		cachedCalss.getContent();
		cachedCalss.getContent();
	}

}
