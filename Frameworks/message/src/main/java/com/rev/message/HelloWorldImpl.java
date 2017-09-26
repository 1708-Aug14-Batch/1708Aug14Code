
package com.rev.message;

import javax.jws.WebService;

//Service Implementing Bean
@WebService(endpointInterface = "com.rev.message.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

