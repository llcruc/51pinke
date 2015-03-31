package com.file.dao;

import java.util.List;

import com.spring.entity.FileComment;

public interface FileCommentDao {
	
	void save(FileComment fileComment);
	
	List<FileComment> findByFileid(int fileid);
	
	void delete(FileComment fileComment);
	
	List<FileComment> findByPage(int fileid,int page,int rowsperpage);
	
	int getPageNum(int fileid,int rowsperpage);
	
	int getDataNum(int fileid);

}
