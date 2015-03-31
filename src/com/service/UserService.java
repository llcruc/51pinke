package com.service;


import com.spring.entity.User;

/**
 * �û�ҵ������ӿ�
 * @author Flyaway
 * 
 */

public interface UserService {
	
	/**
	 * ����û�
	 * @param user �û�
	 */
	void savaUser(User user);
	
	/**
	 * �������ȡ�û�
	 * @param mail ����
	 * @return User
	 */
	User getUser(String mail);
	
	/**
	 * ɾ���û�
	 * @param id
	 */
	void deleteUser(int id);
	
	/**
	 * �����û�
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * ����id��ȡ�û�
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	
}
