package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.file.dao.CategoryDao;
import com.spring.entity.Category;

public class CategoryDaoImpl implements CategoryDao{
	private SessionFactory sessionFactory;

	@Override
	public String getNameById(String cid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from Category c where c.categoryid = ?";
		Query query=session.createQuery(hql);
		query.setString(0, cid);
		@SuppressWarnings("unchecked")
		List<Category> list=query.list();
		Category category=list.get(0);
		session.getTransaction().commit();
		return category.getCategoryname();
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
