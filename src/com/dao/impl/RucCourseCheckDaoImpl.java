package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.dao.RucCourseCheckDao;
import com.spring.entity.RucCourseCheck;

public class RucCourseCheckDaoImpl implements RucCourseCheckDao{
	private SessionFactory sessionFactory;

	@Override
	public void save(RucCourseCheck rucCourseCheck) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(rucCourseCheck);
		session.getTransaction().commit();
	}

	@Override
	public void delete(RucCourseCheck rucCourseCheck) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(rucCourseCheck);
		session.getTransaction().commit();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
