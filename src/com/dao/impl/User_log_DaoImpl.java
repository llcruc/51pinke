package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.spring.entity.LoginLog;
import com.user.dao.User_log_Dao;

/**
 * 用户日志类数据库访问层实现
 * @author Flyaway
 *
 */
public class User_log_DaoImpl implements User_log_Dao{
	
    private SessionFactory sessionFactory;          //定义持久操作所需要的会话工厂
	
    //设置sessionfactory依赖注入
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
