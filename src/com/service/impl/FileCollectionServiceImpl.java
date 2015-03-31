package com.service.impl;

import java.util.List;

import com.file.dao.FileCollectionDao;
import com.service.FileCollectionService;
import com.spring.entity.FileCollection;

public class FileCollectionServiceImpl implements FileCollectionService{
	private FileCollectionDao fileCollectionDao;

	@Override
	public void save(FileCollection fileCollection) {
		// TODO Auto-generated method stub
		fileCollectionDao.save(fileCollection);
	}

	@Override
	public void delete(FileCollection fileCollection) {
		// TODO Auto-generated method stub
		fileCollectionDao.delete(fileCollection);
	}

	@Override
	public List<FileCollection> findByUserid(int userid) {
		// TODO Auto-generated method stub
		return fileCollectionDao.findByUserid(userid);
	}

	@Override
	public List<FileCollection> findByFileid(int fileid) {
		// TODO Auto-generated method stub
		return fileCollectionDao.findByFileid(fileid);
	}

	@Override
	public List<FileCollection> findByUseridAndPage(int userid, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		return fileCollectionDao.findByUseridAndPage(userid, page, rowsperpage);
	}

	@Override
	public int getPageNumByUser(int userid, int rowsperpage) {
		// TODO Auto-generated method stub
		return fileCollectionDao.getPageNumByUser(userid, rowsperpage);
	}

	@Override
	public int getDataNumByUser(int userid) {
		// TODO Auto-generated method stub
		return fileCollectionDao.getDataNumByUser(userid);
	}

	public FileCollectionDao getFileCollectionDao() {
		return fileCollectionDao;
	}

	public void setFileCollectionDao(FileCollectionDao fileCollectionDao) {
		this.fileCollectionDao = fileCollectionDao;
	}

	@Override
	public List<FileCollection> findByUseridAndFileid(int userid, int fileid) {
		// TODO Auto-generated method stub
		return fileCollectionDao.findByUseridAndFileid(userid, fileid);
	}

}
