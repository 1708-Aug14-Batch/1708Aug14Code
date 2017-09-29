
package com.revature.messenger;

import javax.jws.WebService;

/**
 * Service Implementing Bean
 * @author will
 *
 */
@WebService(endpointInterface = "com.revature.messenger.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
    	System.out.println(text);
        return "Hello " + text;
    }
}

