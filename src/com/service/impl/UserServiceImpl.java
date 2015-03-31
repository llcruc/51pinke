package com.service.impl;


import com.service.UserService;
import com.spring.entity.User;
import com.user.dao.UserDao;

/**
 * 用户操作接口实现
 * @author Flyaway
 *
 */
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	//spring注入依赖的setter
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}
	
	public UserDao getUserDao(){
		return userDao;
	}

	@Override
	public void savaUser(User user) {
		// TODO Auto-generated method stub
		userDao.sava(user);
	}

	@Override
	public User getUser(String mail) {
		// TODO Auto-generated method stub
		return userDao.getUser(mail);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		if(userDao.findById(id)!=null){
			userDao.delete(id);
		}
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	

}
