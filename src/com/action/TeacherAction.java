package com.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.service.RucCourseService;
import com.service.RucTeacherScoreService;
import com.service.RucTeacherService;
import com.spring.entity.RucCourse;
import com.spring.entity.RucTeacher;
import com.spring.entity.RucTeacherScore;
import com.spring.entity.User;
import com.util.StringHandler;

public class TeacherAction {
	private RucTeacherService rucTeacherService;
	private RucCourseService rucCourseService;
	private RucTeacherScoreService rucTeacherScoreService;
	
	private RucTeacher rucTeacher;
	private List<RucCourse> courselist;
	
	private int teacherid;
	private int userscore;
	
	public String editeinfo(){
		RucTeacher rucTeacher=new RucTeacher();
		try {
			rucTeacher=rucTeacherService.getTeacherById(teacherid);
			this.setCourselist(rucCourseService.getCourseByTeacher(teacherid));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		this.setRucTeacher(rucTeacher);
		return "teacherinfoedite";
	}
	
	/**
	 * 给教师评分
	 * @return
	 */
	public String teacherscore(){
		ActionContext context=ActionContext.getContext();
		int userid=((User)context.getSession().get("user")).getUserid();
		try {
			RucTeacherScore rucTeacherScore=new RucTeacherScore();
			rucTeacherScore.setDatetime(StringHandler.timeTostr(new Date()));
			rucTeacherScore.setUserid(userid);
			rucTeacherScore.setUserscore(userscore);
			rucTeacherScore.setTeacherid(teacherid);
			rucTeacherScoreService.save(rucTeacherScore);
			
			RucTeacher rucTeacher=new RucTeacher();
			rucTeacher=rucTeacherService.getTeacherById(teacherid);
			int scoretimes=rucTeacher.getScoretimes();
			double score=rucTeacher.getScore();
			score=(score*scoretimes+userscore)/(scoretimes+1);
			rucTeacher.setScore(score);
			rucTeacher.setScoretimes(scoretimes+1);
			rucTeacherService.updateTeacher(rucTeacher);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 教师信息页面
	 * @return
	 */
	public String teacherinfo(){
		this.setRucTeacher(rucTeacherService.getTeacherById(teacherid));
		this.setCourselist(rucCourseService.getCourseByTeacher(teacherid));
		return "teacherinfo";
	}
	
	public RucTeacherService getRucTeacherService() {
		return rucTeacherService;
	}
	
	public void setRucTeacherService(RucTeacherService rucTeacherService) {
		this.rucTeacherService = rucTeacherService;
	}
	
	public RucCourseService getRucCourseService() {
		return rucCourseService;
	}
	
	public void setRucCourseService(RucCourseService rucCourseService) {
		this.rucCourseService = rucCourseService;
	}

	public RucTeacher getRucTeacher() {
		return rucTeacher;
	}

	public void setRucTeacher(RucTeacher rucTeacher) {
		this.rucTeacher = rucTeacher;
	}

	public List<RucCourse> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<RucCourse> courselist) {
		this.courselist = courselist;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public RucTeacherScoreService getRucTeacherScoreService() {
		return rucTeacherScoreService;
	}

	public void setRucTeacherScoreService(
			RucTeacherScoreService rucTeacherScoreService) {
		this.rucTeacherScoreService = rucTeacherScoreService;
	}

	public int getUserscore() {
		return userscore;
	}

	public void setUserscore(int userscore) {
		this.userscore = userscore;
	}
	
	
	

}
