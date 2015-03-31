package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.dao.RucTeacherScoreDao;
import com.spring.entity.RucTeacherScore;

public class RucTeacherScoreDaoImpl implements RucTeacherScoreDao{
	private SessionFactory sessionFactory;

	@Override
	public void save(RucTeacherScore rucTeacherScore) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(rucTeacherScore);
		session.getTransaction().commit();
	}

	@Override
	public List<RucTeacherScore> findByTeacher(int teacherid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucTeacherScore r where r.teacherid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, teacherid);
		@SuppressWarnings("unchecked")
		List<RucTeacherScore> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<RucTeacherScore> findByUserAndTeacher(int userid, int teacherid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucTeacherScore r where r.userid=? and r.teacherid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		query.setInteger(1, teacherid);
		@SuppressWarnings("unchecked")
		List<RucTeacherScore> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
