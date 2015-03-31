package com.file.dao;

import java.util.List;

import com.spring.entity.FileCollection;

public interface FileCollectionDao {
	
	void save(FileCollection fileCollection);
	
	void delete(FileCollection fileCollection);
	
	List<FileCollection> findByUserid(int userid);
	
	List<FileCollection> findByFileid(int fileid);
	
	List<FileCollection> findByUseridAndFileid(int userid,int fileid);
	
	
	//·ÖÒ³
	List<FileCollection> findByUseridAndPage(int userid,int page,int rowsperpage);
	
	int getPageNumByUser(int userid,int rowsperpage);
	
	int getDataNumByUser(int userid);

}
