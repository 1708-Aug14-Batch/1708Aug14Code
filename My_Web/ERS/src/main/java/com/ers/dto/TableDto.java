package com.ers.dto;

import java.util.List;

import com.ers.pojos.User;

public class TableDto<T> {

	private User user;
	private List<T> list;
	
	public TableDto (User user, List<T> list) {
		this.user = user;
		this.list = list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TableDto [user=" + user + ", list=" + list + "]";
	}
}
