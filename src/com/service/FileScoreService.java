package com.service;

import com.spring.entity.FileScore;

/**
 * �ļ����ַ����ӿ�
 * @author Flyaway
 *
 */
public interface FileScoreService {
	/**
	 * �ļ�����
	 * @param fileScore
	 */
	void score(FileScore fileScore);
	
	/**
	 * ��ȡ����
	 * @param fileid
	 * @return
	 */
	double getScore(int fileid);
	
	/**
	 * �����û����ļ���������
	 * @param userid
	 * @param fileid
	 * @return
	 */
	FileScore findbyUserAndFile(int userid,int fileid);

}
