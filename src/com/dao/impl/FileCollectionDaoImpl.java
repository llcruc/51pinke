package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.file.dao.FileCollectionDao;
import com.spring.entity.FileCollection;

public class FileCollectionDaoImpl implements FileCollectionDao{
	private SessionFactory sessionFactory;

	@Override
	public void save(FileCollection fileCollection) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(fileCollection);
		session.getTransaction().commit();
	}

	@Override
	public void delete(FileCollection fileCollection) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(fileCollection);
		session.getTransaction().commit();
	}

	@Override
	public List<FileCollection> findByUserid(int userid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileCollection f where f.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<FileCollection> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<FileCollection> findByFileid(int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileCollection f where f.fileid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, fileid);
		@SuppressWarnings("unchecked")
		List<FileCollection> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<FileCollection> findByUseridAndPage(int userid, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileCollection f where f.userid=? order by datetime desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<FileCollection> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getPageNumByUser(int userid, int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileCollection f where f.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<FileCollection> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage+1;
		}
	}

	@Override
	public int getDataNumByUser(int userid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileCollection f where f.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<FileCollection> list=query.list();
		session.getTransaction().commit();
		return list.size();
	}

	@Override
	public List<FileCollection> findByUseridAndFileid(int userid, int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileCollection f where f.userid=? and f.fileid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		query.setInteger(1, fileid);
		@SuppressWarnings("unchecked")
		List<FileCollection> list=query.list();
		session.getTransaction().commit();
		return list;
	}
}
