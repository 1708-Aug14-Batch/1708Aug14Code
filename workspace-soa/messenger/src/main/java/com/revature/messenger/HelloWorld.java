package com.revature.messenger;

import javax.jws.WebService;

/**
 * Service Endpoint Interface
 * @author will
 *
 */
@WebService
public interface HelloWorld {
    String sayHi(String text);
}

