package org.lavignelibrary.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//So That Spring Can Inject Our Hibernate's SessionFactory 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Short hand for getCurrentSession() because we're fucking lazy
	public Session sess() {
		return getSessionFactory().getCurrentSession();
	}


}
