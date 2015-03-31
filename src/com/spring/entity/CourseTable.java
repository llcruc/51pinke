package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 用户课表实体
 * @author Flyaway
 *
 */
@Entity
@Table(name="t_coursetable")
public class CourseTable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="coursenum")
	private int coursenum;
	
	@Column(name="mon")
	private String mon;
	
	@Column(name="tues")
	private String tues;
	
	@Column(name="wed")
	private String wed;
	
	@Column(name="thur")
	private String thur;
	
	@Column(name="fri")
	private String fri;
	
	@Column(name="sat")
	private String sat;
	
	@Column(name="sun")
	private String sun;
	
	

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

	public int getCoursenum() {
		return coursenum;
	}

	public void setCoursenum(int coursenum) {
		this.coursenum = coursenum;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getTues() {
		return tues;
	}

	public void setTues(String tues) {
		this.tues = tues;
	}

	public String getWed() {
		return wed;
	}

	public void setWed(String wed) {
		this.wed = wed;
	}

	public String getThur() {
		return thur;
	}

	public void setThur(String thur) {
		this.thur = thur;
	}

	public String getFri() {
		return fri;
	}

	public void setFri(String fri) {
		this.fri = fri;
	}

	public String getSat() {
		return sat;
	}

	public void setSat(String sat) {
		this.sat = sat;
	}

	public String getSun() {
		return sun;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}


	
	
	

}
