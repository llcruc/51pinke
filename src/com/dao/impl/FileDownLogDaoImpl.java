package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.file.dao.FileDownLogDao;
import com.spring.entity.FileDownLog;

public class FileDownLogDaoImpl implements FileDownLogDao{
	private SessionFactory sessionFactory;

	@Override
	public void save(FileDownLog fileDownLog) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(fileDownLog);
		session.getTransaction().commit();
	}

	@Override
	public List<FileDownLog> findByUser(int userid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileDownLog f where f.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
	    @SuppressWarnings("unchecked")
		List<FileDownLog> list=query.list();
	    session.getTransaction().commit();
		return list;
	}

	@Override
	public int fileDownloadtimes(int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="form FileDownLog f where f.fileid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, fileid);
		@SuppressWarnings("unchecked")
		List<FileDownLog> list=query.list();
		session.getTransaction().commit();
		return list.size();
	}


	@Override
	public FileDownLog findByUserAndFile(int userid, int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileDownLog f where f.userid=? and f.fileid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		query.setInteger(1, fileid);
		@SuppressWarnings("unchecked")
		List<FileDownLog> list=query.list();
		FileDownLog fileDownLog=new FileDownLog();
		if(list.size()!=0){
			fileDownLog=list.get(0);
		}
		session.getTransaction().commit();
		return fileDownLog;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<FileDownLog> findByUserAndPage(int userid, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileDownLog f where f.userid=? order by downloadtime desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<FileDownLog> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getPageNum(int userid, int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileDownLog f where f.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<FileDownLog> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage+1;
		}
	}

	@Override
	public int getDataNum(int userid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileDownLog f where f.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<FileDownLog> list=query.list();
		session.getTransaction().commit();
		return list.size();
	}
}
