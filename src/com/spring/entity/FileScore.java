package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 文件评分详情实体
 * @author Flyaway
 *
 */
@Entity
@Table(name="t_filescore")
public class FileScore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="fileid")
	private int fileid;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="userscore")
	private int userscore;
	
	@Column(name="datetime")
	private String datetime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getUserscore() {
		return userscore;
	}

	public void setUserscore(int userscore) {
		this.userscore = userscore;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	

}
