package com.ex.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.ex.model.User;

@Service
public class UserServiceImpl implements UserService {

	/*
	 * The package java.concurrent.atomic contains many useful classes to
	 * perform atomic operations. An operation is atomic when you can safely
	 * perform the operation in parallel on multiple threads without using the
	 * synchronized keyword or locks.
	 * 
	 * By using AtomicInteger as a replacement for Integer we're able to
	 * increment the number concurrently in a thread-safe manor without
	 * synchronizing the access to the variable. The method incrementAndGet() is
	 * an atomic operation so we can safely call this method from multiple
	 * threads
	 * 
	 * http://winterbe.com/posts/2015/05/22/java8-concurrency-turotial-atomic-c
	 * ....
	 */
	private static final AtomicInteger counter = new AtomicInteger();

	static List<User> users = new ArrayList<User>(Arrays.asList(new User(counter.incrementAndGet(), "Jon Snow"),
			new User(counter.incrementAndGet(), "Arya Stark"), new User(counter.incrementAndGet(), "Cersei L.")));

	@Override
	public boolean create(User user) {
		if (user == null)
			return false;
		
		user.setId(counter.incrementAndGet());
		users.add(user);
		return true;
	}

	@Override
	public User read(int userId) {
		for (User u : users)
			if (u.getId() == userId)
				return u;
		return null;
	}

	@Override
	public User read(String username) {
		for (User u : users)
			if (u.getUsername().equals(username))
				return u;
		return null;
	}

	@Override
	public boolean update(User user) {
		if (user == null)
			return false;
		
		int index = users.indexOf(user);
		
		if (index < 0)
			return false;
		else {
			users.set(index, user);
			return true;
		}
	}

	@Override
	public boolean delete(User user) {
		if (user == null)
			return false;
		
		User removed = users.remove(user.getId());
		
		if (removed == null)
			return false;
		else return true;
	}

	@Override
	public List<User> readAllUser() {
		return users;
	}

	@Override
	public boolean exists(User user) {
		if (read(user.getUsername()) != null)
			return true;
		else return false;
	}

}
