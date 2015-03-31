package com.service;


import com.spring.entity.User;

/**
 * 用户业务操作接口
 * @author Flyaway
 * 
 */

public interface UserService {
	
	/**
	 * 添加用户
	 * @param user 用户
	 */
	void savaUser(User user);
	
	/**
	 * 按邮箱获取用户
	 * @param mail 邮箱
	 * @return User
	 */
	User getUser(String mail);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(int id);
	
	/**
	 * 更新用户
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	
}
