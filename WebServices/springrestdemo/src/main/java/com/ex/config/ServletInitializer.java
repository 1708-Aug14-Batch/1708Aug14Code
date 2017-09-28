package com.ex.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ex.filter.CORSFilter;

public class ServletInitializer
	extends AbstractAnnotationConfigDispatcherServletInitializer {
	//http://joshlong.com/jl/blogPost/simplified_web_configuration_with_spring.html

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class } ;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	protected Filter[] getServletFilters(){
		return new Filter[] {new CORSFilter()};
	}

}
