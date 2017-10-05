package com.revature.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.soap.HelloWorld;

public class AppService {
	
	public static void main(String[] args) {
		String serviceURL = "http://localhost:8081/SoapServiceDemo/HelloWorld";
		
		JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(HelloWorld.class);
		beanFactory.setAddress(serviceURL);
		
		HelloWorld service = (HelloWorld) beanFactory.create();
		String response = service.sayHi("Will");
		System.out.println(response);
	}

}
