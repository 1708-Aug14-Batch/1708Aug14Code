
package com.revature.messange;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface = "com.revature.messange.HelloWorld")
//Service Implementing Bean
public class HelloWorldImpl implements HelloWorld {

	@Autowired
	HelloWorld hw;


	public void setHw(HelloWorld hw) {
		this.hw = hw;
	}



	@WebMethod
    public String sayHi(String text) {
    	System.out.println(text);
        return "Hello " + text;
    }



	@Override
	@WebMethod
	public <S extends User> S save(S entity) {
		return null;
	}



	@Override
	@WebMethod
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	@WebMethod
	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	@WebMethod
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	@WebMethod
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	@WebMethod
	public Iterable<User> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	@WebMethod
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	@WebMethod
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	@WebMethod
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	@WebMethod
	
	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	@WebMethod
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}

