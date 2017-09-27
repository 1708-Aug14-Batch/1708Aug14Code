package com.revature.andy.HelloWebservice;

import javax.jws.WebService;

@WebService

/*
 * service endpoint interface
 */
public interface HelloWorld {
    String sayHi(String text);
}

