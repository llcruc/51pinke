package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.file.dao.FileCommentDao;
import com.spring.entity.FileComment;

public class FileCommentDaoImpl implements FileCommentDao{
	private SessionFactory sessionFactory;

	@Override
	public void save(FileComment fileComment) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(fileComment);
		session.getTransaction().commit();
	}

	@Override
	public List<FileComment> findByFileid(int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileComment fc where fc.fileid=? order by fc.commentdate desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, fileid);
		@SuppressWarnings("unchecked")
		List<FileComment> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public void delete(FileComment fileComment) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(fileComment);
		session.getTransaction().commit();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<FileComment> findByPage(int fileid, int page, int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileComment f where f.fileid=?  order by f.commentdate desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, fileid);
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<FileComment> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getPageNum(int fileid, int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileComment f where f.fileid=?  order by f.commentdate desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, fileid);
		@SuppressWarnings("unchecked")
		List<FileComment> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage+1;
		}
	}

	@Override
	public int getDataNum(int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileComment f where f.fileid=?  order by f.commentdate desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, fileid);
		@SuppressWarnings("unchecked")
		List<FileComment> list=query.list();
		session.getTransaction().commit();
		return list.size();
	}
	

}
