package com.service;

import java.util.List;

import com.spring.entity.RucTeacher;

public interface RucTeacherService {
	
	void saveTeacher(RucTeacher rucTeacher);
	
	void updateTeacher(RucTeacher rucTeacher);
	
	void deleteTeacher(RucTeacher rucTeacher);
	
	RucTeacher getTeacherById(int id);
	
	RucTeacher geTeacherByName(String teachername);
	
	List<RucTeacher> getAllTeachers();

}
