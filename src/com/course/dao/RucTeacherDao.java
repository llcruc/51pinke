package com.course.dao;

import java.util.List;

import com.spring.entity.RucTeacher;

/**
 * 教师数据库操作层接口
 * @author Flyaway
 *
 */
public interface RucTeacherDao {
	void save(RucTeacher rucTeacher);
	
	void update(RucTeacher rucTeacher);
	
	void delete(RucTeacher rucTeacher);
	
	RucTeacher getById(int id);
	
	RucTeacher getByName(String teachername);
	
	List<RucTeacher> getAllTeachers();
	
	/**
	 * 检索教师
	 * @param word
	 * @param page
	 * @param rowsperpage
	 */
	List<RucTeacher> searchteacher(String word,int page,int rowsperpage);
	
	/**
	 * 获取教师结果页数
	 * @param word
	 * @param rowsperpage
	 * @return
	 */
	int getteacherpageNum(String word,int rowsperpage);
	
	/**
	 * 获取教师结果数
	 * @param word
	 * @return
	 */
	int getTeacherNum(String word);

}
