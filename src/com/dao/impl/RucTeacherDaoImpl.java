package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.dao.RucTeacherDao;
import com.spring.entity.RucTeacher;

public class RucTeacherDaoImpl implements RucTeacherDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(RucTeacher rucTeacher) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(rucTeacher);
		session.getTransaction().commit();
	}

	@Override
	public void update(RucTeacher rucTeacher) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(rucTeacher);
		session.getTransaction().commit();
	}

	@Override
	public void delete(RucTeacher rucTeacher) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(rucTeacher);
		session.getTransaction().commit();
	}

	@Override
	public RucTeacher getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucTeacher r where r.id=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, id);
		@SuppressWarnings("unchecked")
		List<RucTeacher> list=query.list();
		RucTeacher rucTeacher=new RucTeacher();
		if(list.size()!=0){
			rucTeacher=list.get(0);
		}
		session.getTransaction().commit();
		return rucTeacher;
	}

	@Override
	public RucTeacher getByName(String teachername) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucTeacher r where r.teachername=?";
		Query query=session.createQuery(hql);
		query.setString(0, teachername);
		@SuppressWarnings("unchecked")
		List<RucTeacher> list=query.list();
		RucTeacher rucTeacher=new RucTeacher();
		if(list.size()!=0){
			rucTeacher=list.get(0);
		}
		session.getTransaction().commit();
		return rucTeacher;
	}

	@Override
	public List<RucTeacher> getAllTeachers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucTeacher";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<RucTeacher> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<RucTeacher> searchteacher(String word, int page, int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucTeacher r where r.teachername like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<RucTeacher> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getteacherpageNum(String word, int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucTeacher r where r.teachername like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		@SuppressWarnings("unchecked")
		List<RucTeacher> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage+1;
		}
	}

	@Override
	public int getTeacherNum(String word) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucTeacher r where r.teachername like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		@SuppressWarnings("unchecked")
		List<RucTeacher> list=query.list();
		session.getTransaction().commit();
		return list.size();
	}

}
