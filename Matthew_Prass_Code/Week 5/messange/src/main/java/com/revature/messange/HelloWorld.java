package com.revature.messange;

import javax.jws.WebService;

import org.springframework.data.repository.CrudRepository;

@WebService
//Service Endpoint Interface
public interface HelloWorld extends CrudRepository<User , Integer>{
    String sayHi(String text);
}

