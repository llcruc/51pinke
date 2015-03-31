package com.service.impl;

import java.util.List;

import com.file.dao.FileDownLogDao;
import com.service.FileDownLogService;
import com.spring.entity.FileDownLog;

public class FileDownLogServiceImpl implements FileDownLogService{
	private FileDownLogDao fileDownLogDao;

	@Override
	public void save(FileDownLog fileDownLog) {
		// TODO Auto-generated method stub
		fileDownLogDao.save(fileDownLog);
	}

	@Override
	public FileDownLog findByUserAndFile(int userid, int fileid) {
		// TODO Auto-generated method stub
		return fileDownLogDao.findByUserAndFile(userid, fileid);
	}

	@Override
	public List<FileDownLog> findByUser(int userid) {
		// TODO Auto-generated method stub
		return fileDownLogDao.findByUser(userid);
	}

	@Override
	public int fileDownloadtimes(int fileid) {
		// TODO Auto-generated method stub
		return fileDownLogDao.fileDownloadtimes(fileid);
	}

	public FileDownLogDao getFileDownLogDao() {
		return fileDownLogDao;
	}

	public void setFileDownLogDao(FileDownLogDao fileDownLogDao) {
		this.fileDownLogDao = fileDownLogDao;
	}

	@Override
	public List<FileDownLog> findByUserAndPage(int userid, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		return fileDownLogDao.findByUserAndPage(userid, page, rowsperpage);
	}

	@Override
	public int getPageNum(int userid, int rowsperpage) {
		// TODO Auto-generated method stub
		return fileDownLogDao.getPageNum(userid, rowsperpage);
	}

	@Override
	public int getDataNum(int userid) {
		// TODO Auto-generated method stub
		return fileDownLogDao.getDataNum(userid);
	}

}
