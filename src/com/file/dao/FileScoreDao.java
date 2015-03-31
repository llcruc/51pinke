package com.file.dao;

import java.util.List;

import com.spring.entity.FileScore;

/**
 * 文件评分数据库操作接口
 * @author Flyaway
 *
 */
public interface FileScoreDao {
	/**
	 * 新增评分
	 * @param fileScore
	 */
	void save(FileScore fileScore);
	
	/**
	 * 获取一个文件所有评分
	 * @param fileid
	 * @return
	 */
	List<FileScore> findByFileid(int fileid);
	
	/**
	 * 获取一份文件有个用户的评分
	 * @param userid
	 * @param fileid
	 * @return
	 */
	FileScore findByUserAndFile(int userid,int fileid);

}
