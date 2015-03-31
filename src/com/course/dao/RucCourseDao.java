package com.course.dao;

import java.util.List;

import com.spring.entity.RucCourse;

/**
 * ȫУ�γ̱����ݿ���ʲ�ӿ�
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
	 * ��ѯ��ҳ����
	 * @param page ҳ��
	 * @param rowsperpage ÿҳ����
	 * @return
	 */
	List<RucCourse> getCourseByPage(String coursecategory,int page,int rowsperpage);
	
	/**
	 * ��ȡҳ��
	 * @param rowsperpage
	 * @return
	 */
	int getPageNum(String coursecategory,int rowsperpage);
	
	int getDataNum(String coursecategory);
	
	/**
	 * ����
	 * @param word
	 * @param page
	 * @param rowsperpage
	 * @return
	 */
	List<RucCourse> seaechcourse(String word, int page, int rowsperpage);
	
	/**
	 * �����γ�ҳ��
	 * @param word
	 * @param rowsperpage
	 * @return
	 */
	int getsearchpageNum(String word,int rowsperpage);
	
	/**
	 * �����γ�����
	 * @param word
	 * @return
	 */
	int getsearchNum(String word);
	
	/**
	 * ���ݽ�ʦ��ȡ�γ�
	 * @param teacherid
	 * @return
	 */
	List<RucCourse> getCourseByTeacher(int teacherid);

}
