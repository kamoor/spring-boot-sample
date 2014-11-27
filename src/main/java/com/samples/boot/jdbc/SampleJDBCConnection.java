package com.samples.boot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleJDBCConnection {
	
	
	
	    private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public SampleJDBCConnection(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	
}
