package com.revature.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.soap.HelloWorld;

public class AppService {
	
	public static void main(String[] args) {
		/*
		 * Setup for ApacheCXF SOAP Client 
		 * 
		 */
		String serviceURL = "http://localhost:8050/soapservicedemo/HelloWorld";
		
		//Configuration setup
		JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(HelloWorld.class);
		beanFactory.setAddress(serviceURL);
		
		/*
		 * Consume the SOAP Web Service
		 */
		
		HelloWorld helloWorldService = (HelloWorld) beanFactory.create();
		String response = helloWorldService.sayHi("Jonny");
		System.out.println(response);
	}

}
