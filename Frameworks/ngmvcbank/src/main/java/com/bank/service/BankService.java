package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.BankUser;
import com.bank.repository.Dao;

@Service
public class BankService {
	
	@Autowired
	Dao dao;


	public void setDao(Dao dao) {
		System.out.println("service bean, setter injection happening");
		this.dao = dao;
	}
	
	public BankService(){
		System.out.println("instantiating service bean");
	}

	public BankService(Dao dao) {
		super();
		System.out.println("service bean, constructor injection happening");
		this.dao = dao;
	}



	public void getemails(){
		List<String > emails = dao.getEmails();
		for(String e : emails){
			System.out.println(e);
		}
	}
	
	public BankUser addUser(BankUser u){
		dao.addUser(u);
		return u;
	}
	
	public BankUser getUserByUsername(String email){
		return dao.getUserByUsername(email);
	}	

	
}
