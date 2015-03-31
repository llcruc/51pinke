package com.course.dao;

import java.util.List;

import com.spring.entity.CourseTable;

/**
 * �α����ݿ���ʲ�
 * @author Flyaway
 *
 */
public interface CourseTableDao {
	
	void save(CourseTable courseTable);
	
	void update(CourseTable courseTable);
	
	void delete(CourseTable courseTable);
	
	List<CourseTable> getByUser(int userid);
	

}
