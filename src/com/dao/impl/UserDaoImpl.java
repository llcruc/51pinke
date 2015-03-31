package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.spring.entity.User;
import com.user.dao.UserDao;

/**
 * 
 * @author Flyaway
 * �û����ݿ���ʲ�ʵ��
 *
 */

public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;          //����־ò�������Ҫ�ĻỰ����
	
    //����sessionfactory����ע��
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	@Override
	public void sava(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	@Override
	public User getUser(String mail) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hsql="from User u where u.mail=?";
		Query query=session.createQuery(hsql);
		query.setString(0, mail);
		@SuppressWarnings("unchecked")
		List<User> list=query.list();
		if(list.size()!=0){
			User user=list.get(0);
			session.getTransaction().commit();
			return user;
		}else{
			User user=new User();
			session.getTransaction().commit();
			return user;
		}
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hsql="from User u where u.id=?";
		Query query=session.createQuery(hsql);
		query.setInteger(0, id);
		@SuppressWarnings("unchecked")
		List<User> list=query.list();
		if(list.size()!=0){
			User user=list.get(0);
			session.delete(user);
		}
		session.getTransaction().commit();
		
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hsql="from User u where u.id=?";
		Query query=session.createQuery(hsql);
		query.setInteger(0, id);
		@SuppressWarnings("unchecked")
		List<User> list=query.list();
		User user=list.get(0);
		session.getTransaction().commit();
		return user;
	}

	

}
