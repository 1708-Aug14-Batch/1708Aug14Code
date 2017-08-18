package com.bank.dao;

import java.util.List;

/*
 * Generic Data Access Object Interface
 * write() must store list, read must read a file and return a list
 */
public interface DAO<T> {
	void write(List<T> list);
	List<T> read();
}
