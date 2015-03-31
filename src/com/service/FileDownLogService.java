package com.service;

import java.util.List;

import com.spring.entity.FileDownLog;
/**
 * �ļ����ؼ�¼�����ӿ�
 * @author Flyaway
 *
 */
public interface FileDownLogService {
	/**
	 * ������־
	 * @param fileDownLog
	 */
    void save(FileDownLog fileDownLog);
	
    /**
     * �����û�id���ļ�id�ж��Ƿ����ع�
     * @param userid
     * @param fileid
     * @return
     */
	FileDownLog findByUserAndFile(int userid,int fileid);
	
	/**
	 * ��ȡһ���û����ع��������ļ���־
	 * @param userid
	 * @return
	 */
	List<FileDownLog> findByUser(int userid);
	
	/**
	 * ��ȡһ���ļ������ش���
	 * @param fileid
	 * @return
	 */
	int fileDownloadtimes(int fileid);
	
	/**
	 * ��ȡ��ҳ����
	 * @param userid
	 * @param page
	 * @param rowsperpage
	 * @return
	 */
    List<FileDownLog> findByUserAndPage(int userid,int page,int rowsperpage);
	
    /**
     * ��ȡ��ҳ��
     * @param userid
     * @param rowsperpage
     * @return
     */
	int getPageNum(int userid,int rowsperpage);
	
	/**
	 * ��ȡ������
	 * @param userid
	 * @return
	 */
	int getDataNum(int userid);
}
