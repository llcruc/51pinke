package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.file.dao.FileScoreDao;
import com.spring.entity.FileScore;

public class FileScoreDaoImpl implements FileScoreDao{
	private SessionFactory sessionFactory;

	@Override
	public void save(FileScore fileScore) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(fileScore);
		session.getTransaction().commit();
	}

	@Override
	public List<FileScore> findByFileid(int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileScore f where f.fileid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, fileid);
		@SuppressWarnings("unchecked")
		List<FileScore> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public FileScore findByUserAndFile(int userid, int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileScore f where f.userid=? and f.fileid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		query.setInteger(1, fileid);
		@SuppressWarnings("unchecked")
		List<FileScore> list=query.list();
		FileScore fileScore=new FileScore();
		if(list.size()!=0){
			fileScore=list.get(0);
		}
		session.getTransaction().commit();
		return fileScore;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
