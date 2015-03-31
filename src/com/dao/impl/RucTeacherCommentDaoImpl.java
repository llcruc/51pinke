package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.dao.RucTeacherCommentDao;
import com.spring.entity.TeacherComment;

public class RucTeacherCommentDaoImpl implements RucTeacherCommentDao{
	private SessionFactory sessionFactory;

	@Override
	public void save(TeacherComment teacherComment) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(teacherComment);
		session.getTransaction().commit();
	}

	@Override
	public void delete(TeacherComment teacherComment) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(teacherComment);
		session.getTransaction().commit();
	}

	@Override
	public List<TeacherComment> findByTeacher(int teacherid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from TeacherComment t where t.teacherid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, teacherid);
		@SuppressWarnings("unchecked")
		List<TeacherComment> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<TeacherComment> findByTeacherAndPage(int teacherid, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from TeacherComment t where t.teacherid=? order by t.commentdate desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, teacherid);
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<TeacherComment> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getPageNum(int teacherid, int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from TeacherComment t where t.teacherid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, teacherid);
		@SuppressWarnings("unchecked")
		List<TeacherComment> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage+1;
		}
	}

	@Override
	public int getDataNum(int teacherid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from TeacherComment t where t.teacherid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, teacherid);
		@SuppressWarnings("unchecked")
		List<TeacherComment> list=query.list();
        session.getTransaction().commit();
		return list.size();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
