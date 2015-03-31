package com.service;

import java.util.List;

import com.spring.entity.RucCourse;

public interface RucCourseService {
	
	void saveCourse(RucCourse rucCourse);
	
	void updateCourse(RucCourse rucCourse);
	
	RucCourse getCourseByTimeId(String id);
	
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
	 * ���ݽ�ʦ��ȡ�γ�
	 * @param teacherid
	 * @return
	 */
	List<RucCourse> getCourseByTeacher(int teacherid);

}
