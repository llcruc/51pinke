package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.spring.entity.LoginLog;
import com.user.dao.User_log_Dao;

/**
 * �û���־�����ݿ���ʲ�ʵ��
 * @author Flyaway
 *
 */
public class User_log_DaoImpl implements User_log_Dao{
	
    private SessionFactory sessionFactory;          //����־ò�������Ҫ�ĻỰ����
	
    //����sessionfactory����ע��
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void sava(LoginLog loginLog) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(loginLog);
		session.getTransaction().commit();
	}
	

}
