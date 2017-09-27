package com.ex.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.ex.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	/*
	 * The package java.concurrent.atomic contains many useful classes to 
	 * perform atomic operations. An operation is atomic when you can safely
	 * perform the operation in parallel on multiple threads without using 
	 * the synchronized keyword or locks.
	 * 
	 * By using AtomicInteger as a replacement for Integer we're able to 
	 * increment the number concurrently in a thread-safe manor without 
	 * synchronizing the access to the variable. The method incrementAndGet() 
	 * is an atomic operation so we can safely call this method from multiple threads.
	 * 
	 * http://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/
	 */
	private static final AtomicInteger counter
		= new AtomicInteger();
	
	static List<User> users = new ArrayList<User>(Arrays.asList(
			new User(counter.incrementAndGet(), "Jon Snow"),
			new User(counter.incrementAndGet(), "Arya Stark"),
			new User(counter.incrementAndGet(),"Cersei L.")
			));

	@Override
	public void create(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	@Override
	public void update(User user) {
		int index = users.indexOf(user);
		users.set(index,user);
	}

	@Override
	public void delete(User user) {
		users.remove(user);
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User findById(int id) {
		for(User u : users){
			if(u.getId() == id){
				return u;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for(User user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean exists(User user) {
		return findByName(user.getUsername()) != null;
	}

}
