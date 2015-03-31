package com.file.dao;

import java.util.List;

import com.spring.entity.FileScore;

/**
 * �ļ��������ݿ�����ӿ�
 * @author Flyaway
 *
 */
public interface FileScoreDao {
	/**
	 * ��������
	 * @param fileScore
	 */
	void save(FileScore fileScore);
	
	/**
	 * ��ȡһ���ļ���������
	 * @param fileid
	 * @return
	 */
	List<FileScore> findByFileid(int fileid);
	
	/**
	 * ��ȡһ���ļ��и��û�������
	 * @param userid
	 * @param fileid
	 * @return
	 */
	FileScore findByUserAndFile(int userid,int fileid);

}
