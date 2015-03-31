package com.file.dao;

import java.util.List;

import com.spring.entity.FileDownLog;

public interface FileDownLogDao {
	
	void save(FileDownLog fileDownLog);
	
	FileDownLog findByUserAndFile(int userid,int fileid);
	
	List<FileDownLog> findByUser(int userid);
	
	int fileDownloadtimes(int fileid);
	
	List<FileDownLog> findByUserAndPage(int userid,int page,int rowsperpage);
	
	int getPageNum(int userid,int rowsperpage);
	
	int getDataNum(int userid);

}
