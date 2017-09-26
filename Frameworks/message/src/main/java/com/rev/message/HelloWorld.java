package com.rev.message;

import javax.jws.WebService;

//Service Endpoint Interface (SEI)
@WebService
public interface HelloWorld {
    String sayHi(String text);
}

