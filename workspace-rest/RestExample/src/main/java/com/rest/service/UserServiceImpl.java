package com.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.rest.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private static final AtomicInteger COUNTER = new AtomicInteger();
	private static List<User> users = new ArrayList<User>(Arrays.asList(
		new User(COUNTER.incrementAndGet(), "Jon Snow"),
		new User(COUNTER.incrementAndGet(), "Arja Stark"),
		new User(COUNTER.incrementAndGet(), "Cersei Lannister")
	));

	@Override
	public void create(User user) {
		user.setId(COUNTER.incrementAndGet());
		users.add(user);
	}

	@Override
	public void update(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
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
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for (User user : users) {
			if (user.getUserName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean exists(User user) {
		return this.findByName(user.getUserName()) != null;
	}

}
