package com.service;

import java.util.List;

import com.spring.entity.RucCourse;

public interface RucCourseService {
	
	void saveCourse(RucCourse rucCourse);
	
	void updateCourse(RucCourse rucCourse);
	
	RucCourse getCourseByTimeId(String id);
	
	List<RucCourse> getAllCourse();
	
	
	/**
	 * 查询分页数据
	 * @param page 页数
	 * @param rowsperpage 每页条数
	 * @return
	 */
	List<RucCourse> getCourseByPage(String coursecategory,int page,int rowsperpage);
	
	/**
	 * 获取页数
	 * @param rowsperpage
	 * @return
	 */
	int getPageNum(String coursecategory,int rowsperpage);
	
	int getDataNum(String coursecategory);
	
	/**
	 * 根据教师获取课程
	 * @param teacherid
	 * @return
	 */
	List<RucCourse> getCourseByTeacher(int teacherid);

}
