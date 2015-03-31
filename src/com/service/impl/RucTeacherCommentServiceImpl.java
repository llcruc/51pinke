package com.service.impl;

import java.util.List;

import com.course.dao.RucTeacherCommentDao;
import com.service.RucTeacherCommentService;
import com.spring.entity.TeacherComment;

public class RucTeacherCommentServiceImpl implements RucTeacherCommentService{
	private RucTeacherCommentDao rucTeacherCommentDao;

	@Override
	public void save(TeacherComment teacherComment) {
		// TODO Auto-generated method stub
		rucTeacherCommentDao.save(teacherComment);
	}

	@Override
	public void delete(TeacherComment teacherComment) {
		// TODO Auto-generated method stub
		rucTeacherCommentDao.delete(teacherComment);
	}

	@Override
	public List<TeacherComment> findByTeacher(int teacherid) {
		// TODO Auto-generated method stub
		return rucTeacherCommentDao.findByTeacher(teacherid);
	}

	@Override
	public List<TeacherComment> findByTeacherAndPage(int teacherid, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		return rucTeacherCommentDao.findByTeacherAndPage(teacherid, page, rowsperpage);
	}

	@Override
	public int getPageNum(int teacherid, int rowsperpage) {
		// TODO Auto-generated method stub
		return rucTeacherCommentDao.getPageNum(teacherid, rowsperpage);
	}

	@Override
	public int getDataNum(int teacherid) {
		// TODO Auto-generated method stub
		return rucTeacherCommentDao.getDataNum(teacherid);
	}

	public RucTeacherCommentDao getRucTeacherCommentDao() {
		return rucTeacherCommentDao;
	}

	public void setRucTeacherCommentDao(RucTeacherCommentDao rucTeacherCommentDao) {
		this.rucTeacherCommentDao = rucTeacherCommentDao;
	}
	

}
