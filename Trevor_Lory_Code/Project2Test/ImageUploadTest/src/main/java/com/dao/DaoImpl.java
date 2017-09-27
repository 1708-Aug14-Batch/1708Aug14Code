package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Image;
import com.util.ConnectionUtil;

public class DaoImpl {

	public void addImage(Image img) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction)session.beginTransaction();
			session.save(img);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
}
