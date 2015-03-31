package com.service.impl;

import java.util.List;

import com.course.dao.RucTeacherDao;
import com.service.RucTeacherService;
import com.spring.entity.RucTeacher;

public class RucTeacherServiceImpl implements RucTeacherService{
	private RucTeacherDao rucTeacherDao;
	
	public void setRucTeacherDao(RucTeacherDao rucTeacherDao) {
		this.rucTeacherDao = rucTeacherDao;
	}

	@Override
	public void saveTeacher(RucTeacher rucTeacher) {
		// TODO Auto-generated method stub
		rucTeacherDao.save(rucTeacher);
	}

	@Override
	public void updateTeacher(RucTeacher rucTeacher) {
		// TODO Auto-generated method stub
		rucTeacherDao.update(rucTeacher);
	}

	@Override
	public void deleteTeacher(RucTeacher rucTeacher) {
		// TODO Auto-generated method stub
		rucTeacherDao.delete(rucTeacher);
	}

	@Override
	public RucTeacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		return rucTeacherDao.getById(id);
	}

	@Override
	public RucTeacher geTeacherByName(String teachername) {
		// TODO Auto-generated method stub
		return rucTeacherDao.getByName(teachername);
	}

	@Override
	public List<RucTeacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return rucTeacherDao.getAllTeachers();
	}

}
