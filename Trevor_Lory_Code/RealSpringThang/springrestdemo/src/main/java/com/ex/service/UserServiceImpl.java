package com.ex.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.ex.model.User;

@Service
public class UserServiceImpl implements UserService {

	private static final AtomicInteger counter = new AtomicInteger();
	
	static List<User> users = new ArrayList<User>(Arrays.asList(
				new User(counter.getAndIncrement(), "Jon Snow"),
				new User(counter.getAndIncrement(), "Jon Snow"),
				new User(counter.getAndIncrement(), "Jon Snow")
			));
	
	@Override
	public void create(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	@Override
	public void update(User user) {
		for(int i = 0; i < users.size(); i++) {
			if(user.getId() == users.get(i).getId()) {
				users.get(i).setUsername(user.getUsername());
			}
		}
	}

	@Override
	public void delete(User user) {
		for(int i = 0; i < users.size(); i++) {
			if(user.getId() == users.get(i).getId()) {
				users.remove(i);
			}
		}
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User findById(int id) {
		for(User u: users) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for(User u: users) {
			if(u.getUsername().equals(name)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public boolean exists(User user) {
		if(findByName(user.getUsername()) == null) {
			return false;
		}
		return true;
	}

}
