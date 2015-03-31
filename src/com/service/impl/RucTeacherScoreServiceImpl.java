package com.service.impl;

import java.util.List;

import com.course.dao.RucTeacherScoreDao;
import com.service.RucTeacherScoreService;
import com.spring.entity.RucTeacherScore;

public class RucTeacherScoreServiceImpl implements RucTeacherScoreService{
	private RucTeacherScoreDao rucTeacherScoreDao;

	@Override
	public void save(RucTeacherScore rucTeacherScore) {
		// TODO Auto-generated method stub
		rucTeacherScoreDao.save(rucTeacherScore);
	}

	@Override
	public List<RucTeacherScore> findByTeacher(int teacherid) {
		// TODO Auto-generated method stub
		return rucTeacherScoreDao.findByTeacher(teacherid);
	}

	@Override
	public List<RucTeacherScore> findByUserAndTeacher(int userid, int teacherid) {
		// TODO Auto-generated method stub
		return rucTeacherScoreDao.findByUserAndTeacher(userid, teacherid);
	}

	public RucTeacherScoreDao getRucTeacherScoreDao() {
		return rucTeacherScoreDao;
	}

	public void setRucTeacherScoreDao(RucTeacherScoreDao rucTeacherScoreDao) {
		this.rucTeacherScoreDao = rucTeacherScoreDao;
	}

}
