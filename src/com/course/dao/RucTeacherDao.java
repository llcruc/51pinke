package com.course.dao;

import java.util.List;

import com.spring.entity.RucTeacher;

/**
 * ��ʦ���ݿ������ӿ�
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
	 * ������ʦ
	 * @param word
	 * @param page
	 * @param rowsperpage
	 */
	List<RucTeacher> searchteacher(String word,int page,int rowsperpage);
	
	/**
	 * ��ȡ��ʦ���ҳ��
	 * @param word
	 * @param rowsperpage
	 * @return
	 */
	int getteacherpageNum(String word,int rowsperpage);
	
	/**
	 * ��ȡ��ʦ�����
	 * @param word
	 * @return
	 */
	int getTeacherNum(String word);

}
