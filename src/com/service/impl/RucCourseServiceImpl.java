package com.service.impl;

import java.util.List;

import com.course.dao.RucCourseDao;
import com.service.RucCourseService;
import com.spring.entity.RucCourse;

public class RucCourseServiceImpl implements RucCourseService{
	private RucCourseDao rucCourseDao;

	public void setRucCourseDao(RucCourseDao rucCourseDao) {
		this.rucCourseDao = rucCourseDao;
	}


	@Override
	public void saveCourse(RucCourse rucCourse) {
		// TODO Auto-generated method stub
		rucCourseDao.save(rucCourse);
	}


	@Override
	public RucCourse getCourseByTimeId(String coursetimeid) {
		// TODO Auto-generated method stub
		return rucCourseDao.getCourseByTimeid(coursetimeid);
	}


	@Override
	public List<RucCourse> getAllCourse() {
		// TODO Auto-generated method stub
		return rucCourseDao.getAllCourse();
	}


	@Override
	public void updateCourse(RucCourse rucCourse) {
		// TODO Auto-generated method stub
		rucCourseDao.update(rucCourse);
	}


	@Override
	public List<RucCourse> getCourseByPage(String coursecategory, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		return rucCourseDao.getCourseByPage(coursecategory, page, rowsperpage);
	}


	@Override
	public int getPageNum(String coursecategory, int rowsperpage) {
		// TODO Auto-generated method stub
		return rucCourseDao.getPageNum(coursecategory, rowsperpage);
	}


	@Override
	public int getDataNum(String coursecategory) {
		// TODO Auto-generated method stub
		return rucCourseDao.getDataNum(coursecategory);
	}


	@Override
	public List<RucCourse> getCourseByTeacher(int teacherid) {
		// TODO Auto-generated method stub
		return rucCourseDao.getCourseByTeacher(teacherid);
	}

}
