package com.course.dao;

import java.util.List;

import com.spring.entity.RucTeacherScore;

public interface RucTeacherScoreDao {
	
	void save(RucTeacherScore rucTeacherScore);
	
	List<RucTeacherScore> findByTeacher(int teacherid);
	
	List<RucTeacherScore> findByUserAndTeacher(int userid,int teacherid);

}
