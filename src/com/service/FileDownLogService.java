package com.service;

import java.util.List;

import com.spring.entity.FileDownLog;
/**
 * 文件下载记录服务层接口
 * @author Flyaway
 *
 */
public interface FileDownLogService {
	/**
	 * 保存日志
	 * @param fileDownLog
	 */
    void save(FileDownLog fileDownLog);
	
    /**
     * 根据用户id与文件id判断是否下载过
     * @param userid
     * @param fileid
     * @return
     */
	FileDownLog findByUserAndFile(int userid,int fileid);
	
	/**
	 * 获取一个用户下载过的所有文件日志
	 * @param userid
	 * @return
	 */
	List<FileDownLog> findByUser(int userid);
	
	/**
	 * 获取一个文件被下载次数
	 * @param fileid
	 * @return
	 */
	int fileDownloadtimes(int fileid);
	
	/**
	 * 获取分页数据
	 * @param userid
	 * @param page
	 * @param rowsperpage
	 * @return
	 */
    List<FileDownLog> findByUserAndPage(int userid,int page,int rowsperpage);
	
    /**
     * 获取分页数
     * @param userid
     * @param rowsperpage
     * @return
     */
	int getPageNum(int userid,int rowsperpage);
	
	/**
	 * 获取数据量
	 * @param userid
	 * @return
	 */
	int getDataNum(int userid);
}
