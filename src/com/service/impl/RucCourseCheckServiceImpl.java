package com.service.impl;

import com.course.dao.RucCourseCheckDao;
import com.service.RucCourseCheckService;
import com.spring.entity.RucCourseCheck;

public class RucCourseCheckServiceImpl implements RucCourseCheckService{
	private RucCourseCheckDao rucCourseCheckDao;

	@Override
	public void save(RucCourseCheck rucCourseCheck) {
		// TODO Auto-generated method stub
		rucCourseCheckDao.save(rucCourseCheck);
	}

	@Override
	public void delete(RucCourseCheck rucCourseCheck) {
		// TODO Auto-generated method stub
		rucCourseCheckDao.delete(rucCourseCheck);
	}

	public RucCourseCheckDao getRucCourseCheckDao() {
		return rucCourseCheckDao;
	}

	public void setRucCourseCheckDao(RucCourseCheckDao rucCourseCheckDao) {
		this.rucCourseCheckDao = rucCourseCheckDao;
	}
	
	

}
