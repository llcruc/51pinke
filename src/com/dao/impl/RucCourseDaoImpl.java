package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.dao.RucCourseDao;
import com.spring.entity.RucCourse;

public class RucCourseDaoImpl implements RucCourseDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public RucCourse getCourseByTimeid(String coursetimeid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.coursetimeid=?";
		Query query=session.createQuery(hql);
		query.setString(0, coursetimeid);
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		RucCourse rucCourse=new RucCourse();
		if(list.size()!=0){
			rucCourse=list.get(0);
		}
	    session.getTransaction().commit();
		return rucCourse;
	}

	@Override
	public List<RucCourse> getCourseById(int courseid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.courseid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, courseid);
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		session.getTransaction().commit();
		return list;
	}



	@Override
	public void save(RucCourse rucCourse) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(rucCourse);
		session.getTransaction().commit();
	}



	@Override
	public void delete(RucCourse rucCourse) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(rucCourse);
		session.getTransaction().commit();
	}



	@Override
	public void update(RucCourse rucCourse) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(rucCourse);
		session.getTransaction().commit();
	}

	@Override
	public List<RucCourse> getAllCourse() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<RucCourse> getCourseByPage(String coursecategory,int page,int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.coursecategory=?";
		Query query=session.createQuery(hql);
		query.setString(0, coursecategory);
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getPageNum(String coursecategory,int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.coursecategory=?";
		Query query=session.createQuery(hql);
		query.setString(0, coursecategory);
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage +1;
		}
	}

	@Override
	public int getDataNum(String coursecategory) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.coursecategory=?";
		Query query=session.createQuery(hql);
		query.setString(0, coursecategory);
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		return rows;
	}

	@Override
	public List<RucCourse> seaechcourse(String word, int page, int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.coursename like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getsearchpageNum(String word, int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.coursename like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage+1;
		}
	}

	@Override
	public int getsearchNum(String word) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.coursename like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		return rows;
	}

	@Override
	public List<RucCourse> getCourseByTeacher(int teacherid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from RucCourse r where r.teacher=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, teacherid);
		@SuppressWarnings("unchecked")
		List<RucCourse> list=query.list();
		session.getTransaction().commit();
		return list;
	}
}
