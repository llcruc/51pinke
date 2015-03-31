package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_ruc_course")
public class RucCourse {
	@Id
	private String coursetimeid;
	
	@Column(name="courseid")
	private int courseid;
	
	@Column(name="coursename")
	private String coursename;
	
	@Column(name="teacher")
	private int teacher;
	
	@Column(name="coursetime")
	private String coursetime;
	
	@Column(name="coursecategory")
	private String coursecategory;
	
	@Column(name="coursecredit")
	private int coursecredit;
	
	@Column(name="classname")
	private String classname;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="courseimg")
	private String courseimg;
	
	@Column(name="courseinfo")
	private String courseinfo;
	

	public String getCourseinfo() {
		return courseinfo;
	}

	public void setCourseinfo(String courseinfo) {
		this.courseinfo = courseinfo;
	}

	public String getCoursetimeid() {
		return coursetimeid;
	}

	public void setCoursetimeid(String coursetimeid) {
		this.coursetimeid = coursetimeid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


	public int getTeacher() {
		return teacher;
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}

	public String getCoursetime() {
		return coursetime;
	}

	public void setCoursetime(String coursetime) {
		this.coursetime = coursetime;
	}

	public String getCoursecategory() {
		return coursecategory;
	}

	public void setCoursecategory(String coursecategory) {
		this.coursecategory = coursecategory;
	}

	public int getCoursecredit() {
		return coursecredit;
	}

	public void setCoursecredit(int coursecredit) {
		this.coursecredit = coursecredit;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCourseimg() {
		return courseimg;
	}

	public void setCourseimg(String courseimg) {
		this.courseimg = courseimg;
	}
	
	

}
