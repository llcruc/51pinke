package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_teacher")
public class RucTeacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int teacherid;
	
	@Column(name="teachername")
	private String teachername;
	
	@Column(name="teacherinfo")
	private String teacherinfo;
	
	@Column(name="teacherimg")
	private String teacherimg;
	
	@Column(name="score")
	private double score;
	
	@Column(name="scoretimes")
	private int scoretimes;

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeacherinfo() {
		return teacherinfo;
	}

	public void setTeacherinfo(String teacherinfo) {
		this.teacherinfo = teacherinfo;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeacherimg() {
		return teacherimg;
	}

	public void setTeacherimg(String teacherimg) {
		this.teacherimg = teacherimg;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getScoretimes() {
		return scoretimes;
	}

	public void setScoretimes(int scoretimes) {
		this.scoretimes = scoretimes;
	}
	

}
