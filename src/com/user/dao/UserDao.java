package com.user.dao;
/**
 * @author Flyaway
 * �û��������ݿ���ʽӿ�
 * 
 */


import com.spring.entity.User;

public interface UserDao {
	
	//�����û�����
	public void sava(User user);
	
	//��ȡ�û�����
	public User getUser(String mail);
	
	//�޸�Userʵ��
	public void update(User user);
	
	//ɾ��Userʵ��
	public void delete(int id);
	
	//��id�����û�
	public User findById(int id);

}
