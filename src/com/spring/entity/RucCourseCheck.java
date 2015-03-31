package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_ruc_course_check")
public class RucCourseCheck {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="coursetimeid")
	private String coursetimeid;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="courseinfo")
	private String courseinfo;
	
	@Column(name="datetime")
	private String datetime;
	
	@Column(name="courseimg")
	private String courseimg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoursetimeid() {
		return coursetimeid;
	}

	public void setCoursetimeid(String coursetimeid) {
		this.coursetimeid = coursetimeid;
	}

	public String getCourseinfo() {
		return courseinfo;
	}

	public void setCourseinfo(String courseinfo) {
		this.courseinfo = courseinfo;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCourseimg() {
		return courseimg;
	}

	public void setCourseimg(String courseimg) {
		this.courseimg = courseimg;
	}

}
