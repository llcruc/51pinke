package com.service.impl;

import java.util.List;

import com.file.dao.FileDao;
import com.service.FileService;
import com.spring.entity.FileEntity;

/**
 * 文件操作服务层接口实现
 * @author Flyaway
 *
 */
public class FileServiceImpl implements FileService{
	
	private FileDao fileDao;
	

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Override
	public void uploadfile(FileEntity file) {
		// TODO Auto-generated method stub
		fileDao.uploadfile(file);
	}

	@Override
	public void updatefile(FileEntity file) {
		// TODO Auto-generated method stub
		fileDao.update(file);
	}

	@Override
	public FileEntity getfileById(int fileid) {
		// TODO Auto-generated method stub
		return fileDao.getfileById(fileid);
	}

	@Override
	public List<FileEntity> getfileByUser(int userid) {
		// TODO Auto-generated method stub
		return fileDao.getfileByUser(userid);
	}

	@Override
	public void delete(int fileid) {
		// TODO Auto-generated method stub
		fileDao.delete(fileid);
		
	}

	@Override
	public FileEntity getfileByUserAndTime(int userid, String uploadtime) {
		// TODO Auto-generated method stub
		return fileDao.getfileByUserAndId(userid, uploadtime);
	}

	@Override
	public List<FileEntity> getlikelyfile(String cid) {
		// TODO Auto-generated method stub
		return fileDao.getlikelyfile(cid);
	}

	@Override
	public List<FileEntity> findByUserAndPage(int userid, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		return fileDao.findByUserAndPage(userid, page, rowsperpage);
	}

	@Override
	public int getPageNumByUser(int userid, int rowsperpage) {
		// TODO Auto-generated method stub
		return fileDao.getPageNumByUser(userid, rowsperpage);
	}

	@Override
	public int getFileNumByUser(int userid) {
		// TODO Auto-generated method stub
		return fileDao.getFileNumByUser(userid);
	}

	@Override
	public int getFileTotalNum() {
		// TODO Auto-generated method stub
		return fileDao.getFileTotalNum();
	}

}
