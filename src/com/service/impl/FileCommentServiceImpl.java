package com.service.impl;

import java.util.List;

import com.file.dao.FileCommentDao;
import com.service.FileCommentService;
import com.spring.entity.FileComment;

public class FileCommentServiceImpl implements FileCommentService{
	private FileCommentDao fileCommentDao;

	@Override
	public void save(FileComment fileComment) {
		// TODO Auto-generated method stub
		fileCommentDao.save(fileComment);
	}

	@Override
	public List<FileComment> findByFileid(int fileid) {
		// TODO Auto-generated method stub
		return fileCommentDao.findByFileid(fileid);
	}

	@Override
	public void delete(FileComment fileComment) {
		// TODO Auto-generated method stub
		fileCommentDao.delete(fileComment);
	}

	public FileCommentDao getFileCommentDao() {
		return fileCommentDao;
	}

	public void setFileCommentDao(FileCommentDao fileCommentDao) {
		this.fileCommentDao = fileCommentDao;
	}

	@Override
	public List<FileComment> findByPage(int fileid, int page, int rowsperpage) {
		// TODO Auto-generated method stub
		return fileCommentDao.findByPage(fileid, page, rowsperpage);
	}

	@Override
	public int getPageNum(int fileid, int rowsperpage) {
		// TODO Auto-generated method stub
		return fileCommentDao.getPageNum(fileid, rowsperpage);
	}

	@Override
	public int getDataNum(int fileid) {
		// TODO Auto-generated method stub
		return fileCommentDao.getDataNum(fileid);
	}

}
