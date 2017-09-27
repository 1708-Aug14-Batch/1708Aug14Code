package com.ex.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CORSFilter {
	/*
	 * A common problem while developing single page
	 *  applications or applications that use AJAX is Cross 
	 *  Origin Resource Sharing or CORS. For security reasons, 
	 *  most browsers block requests originating from another 
	 *  domain outside the domain from which the request/resource originated.
	 *  
	 *  Solution: Cross-Origin Resource Sharing. We can add HTTP 
	 *  response headers to control inter-domain communication. 
	 *  Using Spring MVC 4 the easiest way is to add a filter.
	 */
	
	
	private final Logger LOG = 
			LoggerFactory.getLogger(CORSFilter.class);
	
    protected void doFilterInternal(HttpServletRequest req, 
    		HttpServletResponse res, FilterChain chain) 
    				throws ServletException, IOException {
    	
        LOG.info("Adding CORS Headers ........................");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", 
        			"POST, GET, PUT, OPTIONS, DELETE");
        res.setHeader("Access-Control-Allow-Headers", "*");
        res.setHeader("Access-Control-Max-Age", "3600");
        chain.doFilter(req, res);
    }
    
    /*
     *Access-Control-Allow-Origin header is required. it
     *indicates which origin site(s) is/are allowed. This 
     *header can contain only a single domain or can allow 
     *a "*" to allow requests from any origin.
     *methods - controls what http are supported
     *access-control-max-age = value allows the response
     *to be cahced for a specified number of seconds 
     * 
     */
	

}
