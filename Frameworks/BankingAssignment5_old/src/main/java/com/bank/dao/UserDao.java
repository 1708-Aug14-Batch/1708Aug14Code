package com.bank.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.User;

@Repository
@Transactional
public interface UserDao {
	
	public User findUserByUsername(String username);
	
	public void createUser(User user);
}
