package com.service;

import java.util.List;

import com.spring.entity.CourseTable;

/**
 * �α�ҵ������ӿ�
 * @author Flyaway
 *
 */
public interface CourseTableService {
	
	void saveCourse(CourseTable courseTable);
	
	void updateCourse(CourseTable courseTable);
	
	void deleteCourse(CourseTable courseTable);
	
	List<CourseTable> getCourseByUser(int userid);
	

}
