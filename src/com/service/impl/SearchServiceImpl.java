package com.service.impl;

import java.util.List;

import com.course.dao.RucCourseDao;
import com.course.dao.RucTeacherDao;
import com.file.dao.FileDao;
import com.service.SearchService;
import com.spring.entity.FileEntity;
import com.spring.entity.RucCourse;
import com.spring.entity.RucTeacher;

public class SearchServiceImpl implements SearchService{
	
	private FileDao fileDao;
	private RucCourseDao rucCourseDao;
	private RucTeacherDao rucTeacherDao;

	@Override
	public List<FileEntity> searchfile(String word, int page, int rowsperpage) {
		// TODO Auto-generated method stub
		return fileDao.searchfile(word, page, rowsperpage);
		
	}

	@Override
	public int getfilepageNum(String word, int rowsperpage) {
		// TODO Auto-generated method stub
		return fileDao.getfilepageNum(word, rowsperpage);
	}

	@Override
	public int getfileNum(String word) {
		// TODO Auto-generated method stub
		return fileDao.getfileNum(word);
	}

	@Override
	public List<RucTeacher> searchteacher(String word, int page, int rowsperpage) {
		// TODO Auto-generated method stub
		return rucTeacherDao.searchteacher(word, page, rowsperpage);
		
	}

	@Override
	public int getteacherpageNum(String word, int rowsperpage) {
		// TODO Auto-generated method stub
		return rucTeacherDao.getteacherpageNum(word, rowsperpage);
	}

	@Override
	public int getTeacherNum(String word) {
		// TODO Auto-generated method stub
		return rucTeacherDao.getTeacherNum(word);
	}

	@Override
	public List<RucCourse> seaechcourse(String word, int page, int rowsperpage) {
		// TODO Auto-generated method stub
		return rucCourseDao.seaechcourse(word, page, rowsperpage);
	}

	@Override
	public int getcoursepageNum(String word, int rowsperpage) {
		// TODO Auto-generated method stub
		return rucCourseDao.getsearchpageNum(word, rowsperpage);
	}

	@Override
	public int getcourseNum(String word) {
		// TODO Auto-generated method stub
		return rucCourseDao.getsearchNum(word);
	}

	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	public RucCourseDao getRucCourseDao() {
		return rucCourseDao;
	}

	public void setRucCourseDao(RucCourseDao rucCourseDao) {
		this.rucCourseDao = rucCourseDao;
	}

	public RucTeacherDao getRucTeacherDao() {
		return rucTeacherDao;
	}

	public void setRucTeacherDao(RucTeacherDao rucTeacherDao) {
		this.rucTeacherDao = rucTeacherDao;
	}

}
