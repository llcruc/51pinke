package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.dao.CourseTableDao;
import com.spring.entity.CourseTable;

/**
 * 课表数据库访问层接口实现
 * @author Flyaway
 *
 */
public class CourseTableDaoImpl implements CourseTableDao{
    private SessionFactory sessionFactory;
    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(CourseTable courseTable) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(courseTable);
		session.getTransaction().commit();
	}

	@Override
	public void update(CourseTable courseTable) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(courseTable);
		session.getTransaction().commit();
	}

	@Override
	public void delete(CourseTable courseTable) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(courseTable);
		session.getTransaction().commit();
	}

	@Override
	public List<CourseTable> getByUser(int userid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from CourseTable c where c.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<CourseTable> list=query.list();
		session.getTransaction().commit();
		return list;
	}
	

}
