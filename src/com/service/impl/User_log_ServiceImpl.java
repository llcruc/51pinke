package com.service.impl;

import com.service.User_log_Service;
import com.spring.entity.LoginLog;
import com.user.dao.User_log_Dao;

public class User_log_ServiceImpl implements User_log_Service{
	private User_log_Dao user_log_Dao;


	public User_log_Dao getUser_log_Dao() {
		return user_log_Dao;
	}


	public void setUser_log_Dao(User_log_Dao user_log_Dao) {
		this.user_log_Dao = user_log_Dao;
	}


	@Override
	public void sava(LoginLog loginLog) {
		// TODO Auto-generated method stub
		user_log_Dao.sava(loginLog);
		
	}
	

}
