package com.service.impl;

import java.util.List;

import com.file.dao.FileScoreDao;
import com.service.FileScoreService;
import com.spring.entity.FileScore;

public class FileScoreServiceImpl implements FileScoreService{
	private FileScoreDao fileScoreDao;

	@Override
	public void score(FileScore fileScore) {
		// TODO Auto-generated method stub
		fileScoreDao.save(fileScore);
	}

	@Override
	public double getScore(int fileid) {
		// TODO Auto-generated method stub
		List<FileScore> list=fileScoreDao.findByFileid(fileid);
		double total=0.0;
		FileScore fileScore=new FileScore();
		for(int i=0;i<list.size();i++){
			fileScore=list.get(i);
			total+=fileScore.getUserscore();
		}
		return (total/list.size())*1.0;
	}

	@Override
	public FileScore findbyUserAndFile(int userid, int fileid) {
		// TODO Auto-generated method stub
		return fileScoreDao.findByUserAndFile(userid, fileid);
	}

	public FileScoreDao getFileScoreDao() {
		return fileScoreDao;
	}

	public void setFileScoreDao(FileScoreDao fileScoreDao) {
		this.fileScoreDao = fileScoreDao;
	}

}
