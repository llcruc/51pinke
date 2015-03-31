package com.service;

import java.util.List;

import com.spring.entity.FileEntity;
import com.spring.entity.RucCourse;
import com.spring.entity.RucTeacher;

public interface SearchService {
	/**
	 * 检索文件
	 * @param word
	 * @param page
	 * @param rowsperpage
	 */
	List<FileEntity> searchfile(String word,int page,int rowsperpage);
	
	/**
	 * 检索文件页数
	 * @param word
	 * @param rowsperpage
	 * @return
	 */
	int getfilepageNum(String word,int rowsperpage);
	
	/**
	 * 检索文件数量
	 * @param word
	 * @return
	 */
	int getfileNum(String word);
	
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
	
	/**
	 * 检索课程
	 * @param word
	 * @param page
	 * @param rowsperpage
	 */
	List<RucCourse> seaechcourse(String word,int page,int rowsperpage);
	
	/**
	 * 检索课程页数
	 * @param word
	 * @param rowsperpage
	 * @return
	 */
	int getcoursepageNum(String word,int rowsperpage);
	
	/**
	 * 检索课程数量
	 * @param word
	 * @return
	 */
	int getcourseNum(String word);

}
