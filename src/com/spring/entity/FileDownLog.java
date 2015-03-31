package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_filedown_log")
public class FileDownLog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="fileid")
	private int fileid;
	
	@Column(name="downloadtime")
	private String downloadtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public String getDownloadtime() {
		return downloadtime;
	}

	public void setDownloadtime(String downloadtime) {
		this.downloadtime = downloadtime;
	}
	

}
