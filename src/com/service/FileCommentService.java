package com.service;

import java.util.List;

import com.spring.entity.FileComment;

public interface FileCommentService {
	/**
	 * ��������
	 * @param fileComment
	 */
    void save(FileComment fileComment);
	
    /**
     * ��ȡ���ļ���������
     * @param fileid
     * @return
     */
	List<FileComment> findByFileid(int fileid);
	
	/**
	 * ɾ������
	 * @param fileComment
	 */
	void delete(FileComment fileComment);
	
	/**
	 * ���۷�ҳ
	 * @param fileid
	 * @param page
	 * @param rowsperpage
	 * @return
	 */
    List<FileComment> findByPage(int fileid,int page,int rowsperpage);
	
	int getPageNum(int fileid,int rowsperpage);
	
	int getDataNum(int fileid);

}
