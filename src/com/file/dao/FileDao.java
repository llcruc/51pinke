package com.file.dao;

import java.util.List;

import com.spring.entity.FileEntity;

/**
 * 文件数据访问接口
 * @author Flyaway
 *
 */
public interface FileDao {
	
	//上传文件
	public void uploadfile(FileEntity file);
	
    //获取一个用户所有文件
	public List<FileEntity> getfileByUser(int userid);
    
    //通过id获取文件信息
    public FileEntity getfileById(int fileid);
    
    //修改文件信息
    public void update(FileEntity file);
    
    //删除文件信息
    public void delete(int fileid);
    
    //通过用户id与文件名获取文件
    public FileEntity getfileByUserAndId(int userid,String uploadtime);
    
    List<FileEntity> searchfile(String word,int page,int rowsperpage);
    
    int getfilepageNum(String word,int rowsperpage);
    
    int getfileNum(String word);
    
    //获取同类别类似文件
    List<FileEntity> getlikelyfile(String cid);
    
    //用户文件分页
    List<FileEntity> findByUserAndPage(int userid,int page,int rowsperpage);
    
    int getPageNumByUser(int userid,int rowsperpage);
    
    int getFileNumByUser(int userid);
    
    //获取文件数量
    int getFileTotalNum();
    
    
}
