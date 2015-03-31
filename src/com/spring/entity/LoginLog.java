package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ��¼��־ʵ��
 * @author Flyaway
 * @version v1.0
 *
 */
@Entity
@Table(name="t_login_log")
public class LoginLog {
	//��¼��־��
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="login_log_id")
	private int Login_log_id;
	
	//��¼�û�id
	@Column(name="userid")
	private int userid;
	
	//��¼�û�ip
	@Column(name="login_ip")
	private String login_ip;
	
	//��¼ʱ��
	@Column(name="login_datetime")
	private String login_datetime;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public String getLogin_datetime() {
		return login_datetime;
	}

	public void setLogin_datetime(String login_datetime) {
		this.login_datetime = login_datetime;
	}

	public int getLogin_log_id() {
		return Login_log_id;
	}

	public void setLogin_log_id(int login_log_id) {
		Login_log_id = login_log_id;
	}
	
	
}
