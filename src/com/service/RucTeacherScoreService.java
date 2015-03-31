package com.service;

import java.util.List;

import com.spring.entity.RucTeacherScore;

public interface RucTeacherScoreService {
	/**
	 * ��������
	 * @param rucTeacherScore
	 */
    void save(RucTeacherScore rucTeacherScore);
	
    /**
     * ���ݽ�ʦѰ������
     * @param teacherid
     * @return
     */
	List<RucTeacherScore> findByTeacher(int teacherid);
	
	/**
	 * �����û��Լ���ʦѰ������
	 * @param userid
	 * @param teacherid
	 * @return
	 */
	List<RucTeacherScore> findByUserAndTeacher(int userid,int teacherid);
}
