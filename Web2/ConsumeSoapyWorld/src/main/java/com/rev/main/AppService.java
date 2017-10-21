package com.rev.main;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.rev.setup.HelloWorld;

public class AppService {
	
	public static void main(String[] args) {
		

	String serviceUrl = "http://192.168.60.75:8050/soapservicedemo/HelloWorld";
	
	JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
	beanFactory.setServiceClass(HelloWorld.class);
	beanFactory.setAddress(serviceUrl);
	
	
	HelloWorld helloWorldService = (HelloWorld)beanFactory.create();
	
	String response = helloWorldService.sayHi("hello? it's me");
	System.out.println(response);
	
	}

}
