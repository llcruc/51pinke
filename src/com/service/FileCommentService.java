package com.service;

import java.util.List;

import com.spring.entity.FileComment;

public interface FileCommentService {
	/**
	 * 新增评论
	 * @param fileComment
	 */
    void save(FileComment fileComment);
	
    /**
     * 获取该文件所有评论
     * @param fileid
     * @return
     */
	List<FileComment> findByFileid(int fileid);
	
	/**
	 * 删除评论
	 * @param fileComment
	 */
	void delete(FileComment fileComment);
	
	/**
	 * 评论分页
	 * @param fileid
	 * @param page
	 * @param rowsperpage
	 * @return
	 */
    List<FileComment> findByPage(int fileid,int page,int rowsperpage);
	
	int getPageNum(int fileid,int rowsperpage);
	
	int getDataNum(int fileid);

}
