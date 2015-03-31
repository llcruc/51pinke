package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �û�ʵ��
 * @author Flyaway
 * @version v1.0
 *
 */
@Entity
@Table(name="t_user")
public class User {
	//�û����
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	private int userid;
	//�û�����
	@Column(name="mail")
	private String mail;
	//�û�����
	@Column(name="password")
	private String password;
	//�û��ǳ�
	@Column(name="nickname")
	private String nickname;
	//�û�ͷ��
	@Column(name="usericon")
	private String usericon;
	//�û�ע��ʱ��
	@Column(name="registedate")
	private String registedate;
	//�û��Ƿ񼤻�
	@Column(name="activate")
	private int activate;
	//�û�����¼ʱ��
	@Column(name="last_visit")
	private String lastvisite;
	//�û�����¼ip
	@Column(name="last_ip")
	private String lastip;
	//�û�����
	@Column(name="credit")
	private Integer credit;
	//�û��Ա�
	@Column(name="gender")
	private Integer gender;
	//�û�ѧУ
	@Column(name="college")
	private String college;
	//�û���������
	@Column(name="borndate")
	private String borndate;
	//�û���ַ
	@Column(name="address")
	private String address;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRegistedate() {
		return registedate;
	}
	public void setRegistedate(String registedate) {
		this.registedate = registedate;
	}
	public int getActivate() {
		return activate;
	}
	public void setActivate(int activate) {
		this.activate = activate;
	}
	public String getLastvisite() {
		return lastvisite;
	}
	public void setLastvisite(String lastvisite) {
		this.lastvisite = lastvisite;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getBorndate() {
		return borndate;
	}
	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsericon() {
		return usericon;
	}
	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}
	
}
