package com.service;

import java.util.List;

import com.spring.entity.TeacherComment;

public interface RucTeacherCommentService {
    void save(TeacherComment teacherComment);
	
	void delete(TeacherComment teacherComment);
	
	List<TeacherComment> findByTeacher(int teacherid);
	
	List<TeacherComment> findByTeacherAndPage(int teacherid,int page,int rowsperpage);
	
	int getPageNum(int teacherid,int rowsperpage);
	
	int getDataNum(int teacherid);
}
