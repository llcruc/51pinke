package com.service.impl;

import java.util.List;

import com.course.dao.CourseTableDao;
import com.service.CourseTableService;
import com.spring.entity.CourseTable;
/**
 * 课表数据库服务层接口
 * @author Flyaway
 *
 */
public class CourseTableServiceImpl implements CourseTableService{
	private CourseTableDao courseTableDao;
	

	public void setCourseTableDao(CourseTableDao courseTableDao) {
		this.courseTableDao = courseTableDao;
	}

	@Override
	public void saveCourse(CourseTable courseTable) {
		// TODO Auto-generated method stub
		courseTableDao.save(courseTable);
	}

	@Override
	public void updateCourse(CourseTable courseTable) {
		// TODO Auto-generated method stub
		courseTableDao.update(courseTable);
	}

	@Override
	public void deleteCourse(CourseTable courseTable) {
		// TODO Auto-generated method stub
		courseTableDao.delete(courseTable);
	}

	@Override
	public List<CourseTable> getCourseByUser(int userid) {
		// TODO Auto-generated method stub
		return courseTableDao.getByUser(userid);
	}
	

}
