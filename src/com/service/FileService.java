package com.service;

import java.util.List;

import com.spring.entity.FileEntity;

/**
 * 用户上传文档服务层接口
 * @author Flyaway
 *
 */
public interface FileService {
	

    /**
     * 上传文档保存信息
     * @param file 文件实体
     */
	public void uploadfile(FileEntity file);
	
	/**
	 * 更新文件信息
	 * @param file 文件实体
	 */
	public void updatefile(FileEntity file);
	
	/**
	 * 根据id号获取文件信息
	 * @param fileid 文件id
	 * @return
	 */
	public FileEntity getfileById(int fileid);
	
	/**
	 * 根据用户与文件上传时间获取文件ID
	 * @param userid 用户id
	 * @param uploadtime 文件上传时间
	 * @return
	 */
	public FileEntity getfileByUserAndTime(int userid,String uploadtime);
	
	/**
	 * 获取用户全部id
	 * @param userid 用户id
	 * @return
	 */
	public List<FileEntity> getfileByUser(int userid);
	
	/**
	 * 删除文件
	 * @param fileid 文件id
	 */
	public void delete(int fileid);
	
	/**
	 * 获取同类别推荐文档
	 * @param cid
	 * @return
	 */
	List<FileEntity> getlikelyfile(String cid);
	
	/**
	 * 根据用户id获取分页文件
	 * @param userid
	 * @param page
	 * @param rowsperpage
	 * @return
	 */
    List<FileEntity> findByUserAndPage(int userid,int page,int rowsperpage);
    
    /**
     * 根据用户id获取页数
     * @param userid
     * @param rowsperpage
     * @return
     */
    int getPageNumByUser(int userid,int rowsperpage);
    
    /**
     * 根据用户di获取文件数
     * @param userid
     * @return
     */
    int getFileNumByUser(int userid);
    
    /**
     * 获取文件总量
     * @return
     */
    int getFileTotalNum();

}
