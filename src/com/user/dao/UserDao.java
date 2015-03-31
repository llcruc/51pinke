package com.user.dao;
/**
 * @author Flyaway
 * 用户对象数据库访问接口
 * 
 */


import com.spring.entity.User;

public interface UserDao {
	
	//保存用户对象
	public void sava(User user);
	
	//获取用户对象
	public User getUser(String mail);
	
	//修改User实例
	public void update(User user);
	
	//删除User实例
	public void delete(int id);
	
	//按id查找用户
	public User findById(int id);

}
