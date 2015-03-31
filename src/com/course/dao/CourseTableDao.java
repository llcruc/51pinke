package com.course.dao;

import java.util.List;

import com.spring.entity.CourseTable;

/**
 * 课表数据库访问层
 * @author Flyaway
 *
 */
public interface CourseTableDao {
	
	void save(CourseTable courseTable);
	
	void update(CourseTable courseTable);
	
	void delete(CourseTable courseTable);
	
	List<CourseTable> getByUser(int userid);
	

}
