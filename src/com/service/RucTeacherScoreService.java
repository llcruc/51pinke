package com.service;

import java.util.List;

import com.spring.entity.RucTeacherScore;

public interface RucTeacherScoreService {
	/**
	 * 保存评分
	 * @param rucTeacherScore
	 */
    void save(RucTeacherScore rucTeacherScore);
	
    /**
     * 根据教师寻找评分
     * @param teacherid
     * @return
     */
	List<RucTeacherScore> findByTeacher(int teacherid);
	
	/**
	 * 根据用户以及教师寻找评分
	 * @param userid
	 * @param teacherid
	 * @return
	 */
	List<RucTeacherScore> findByUserAndTeacher(int userid,int teacherid);
}
