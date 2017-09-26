package com.bank.webservices;

import javax.jws.WebService;

//Service Endpoint Interface (SEI)
@WebService
public interface UserService {
    String getUser(String username);
}

