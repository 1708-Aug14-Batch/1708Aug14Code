package com.bank.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.beans.Person;
import com.bank.util.ConnectionUtil;

public class HibernateDao<T> {

	// CREATE
	public Integer create(T obj) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		Integer id = null;

		try {
			tx = session.beginTransaction();

			id = (Integer) session.save(obj);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return id;
	}
	
	/* UPDATE */
	public void update(T obj) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.update(obj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// TODO Update the below code to work for generics as opposed to Employees
	// TODO Make a READ operation with uniqueResult() instead of list()
	/* DELETE */
	public void deletePerson(Integer id) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Person person = (Person)session.get(Person.class, id);
			session.delete(person);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// READ ALL
	public List<T> readAll(String str) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		List<T> objects = null;
		
		try {
			tx = session.beginTransaction();
			objects = session.createQuery("FROM " + str).list();
			for (Iterator<T> iterator = objects.iterator(); iterator.hasNext();) {
				objects.add(iterator.next());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return objects;
	}
}