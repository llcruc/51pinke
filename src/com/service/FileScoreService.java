package com.service;

import com.spring.entity.FileScore;

/**
 * 文件评分服务层接口
 * @author Flyaway
 *
 */
public interface FileScoreService {
	/**
	 * 文件评分
	 * @param fileScore
	 */
	void score(FileScore fileScore);
	
	/**
	 * 获取评分
	 * @param fileid
	 * @return
	 */
	double getScore(int fileid);
	
	/**
	 * 根据用户和文件查找评分
	 * @param userid
	 * @param fileid
	 * @return
	 */
	FileScore findbyUserAndFile(int userid,int fileid);

}
