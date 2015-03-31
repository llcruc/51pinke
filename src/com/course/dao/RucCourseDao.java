package com.course.dao;

import java.util.List;

import com.spring.entity.RucCourse;

/**
 * 全校课程表数据库访问层接口
 * @author Flyaway
 *
 */
public interface RucCourseDao {
	
	void save(RucCourse rucCourse);
	
	void delete(RucCourse rucCourse);
	
	void update(RucCourse rucCourse);
	
	RucCourse getCourseByTimeid(String coursetimeid);
	
	List<RucCourse> getCourseById(int courseid);
	
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
	 * 检索
	 * @param word
	 * @param page
	 * @param rowsperpage
	 * @return
	 */
	List<RucCourse> seaechcourse(String word, int page, int rowsperpage);
	
	/**
	 * 检索课程页数
	 * @param word
	 * @param rowsperpage
	 * @return
	 */
	int getsearchpageNum(String word,int rowsperpage);
	
	/**
	 * 检索课程数量
	 * @param word
	 * @return
	 */
	int getsearchNum(String word);
	
	/**
	 * 根据教师获取课程
	 * @param teacherid
	 * @return
	 */
	List<RucCourse> getCourseByTeacher(int teacherid);

}
