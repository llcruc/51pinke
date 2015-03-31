package com.service;

import java.util.List;

import com.spring.entity.FileEntity;
import com.spring.entity.RucCourse;
import com.spring.entity.RucTeacher;

public interface SearchService {
	/**
	 * �����ļ�
	 * @param word
	 * @param page
	 * @param rowsperpage
	 */
	List<FileEntity> searchfile(String word,int page,int rowsperpage);
	
	/**
	 * �����ļ�ҳ��
	 * @param word
	 * @param rowsperpage
	 * @return
	 */
	int getfilepageNum(String word,int rowsperpage);
	
	/**
	 * �����ļ�����
	 * @param word
	 * @return
	 */
	int getfileNum(String word);
	
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
	
	/**
	 * �����γ�
	 * @param word
	 * @param page
	 * @param rowsperpage
	 */
	List<RucCourse> seaechcourse(String word,int page,int rowsperpage);
	
	/**
	 * �����γ�ҳ��
	 * @param word
	 * @param rowsperpage
	 * @return
	 */
	int getcoursepageNum(String word,int rowsperpage);
	
	/**
	 * �����γ�����
	 * @param word
	 * @return
	 */
	int getcourseNum(String word);

}
