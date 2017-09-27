package com.ex.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ex.filter.CORSFilter;


public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	 protected Class<?>[] getServletConfigClasses() {
	        return new Class[] { WebConfig.class };
	    }

	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }

	    protected Class<?>[] getRootConfigClasses() {
	        return null;
	    }

	    protected Filter[] getServletFilters() {
	        return new Filter[]{ new CORSFilter()};
	    }

}
