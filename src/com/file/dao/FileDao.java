package com.file.dao;

import java.util.List;

import com.spring.entity.FileEntity;

/**
 * �ļ����ݷ��ʽӿ�
 * @author Flyaway
 *
 */
public interface FileDao {
	
	//�ϴ��ļ�
	public void uploadfile(FileEntity file);
	
    //��ȡһ���û������ļ�
	public List<FileEntity> getfileByUser(int userid);
    
    //ͨ��id��ȡ�ļ���Ϣ
    public FileEntity getfileById(int fileid);
    
    //�޸��ļ���Ϣ
    public void update(FileEntity file);
    
    //ɾ���ļ���Ϣ
    public void delete(int fileid);
    
    //ͨ���û�id���ļ�����ȡ�ļ�
    public FileEntity getfileByUserAndId(int userid,String uploadtime);
    
    List<FileEntity> searchfile(String word,int page,int rowsperpage);
    
    int getfilepageNum(String word,int rowsperpage);
    
    int getfileNum(String word);
    
    //��ȡͬ��������ļ�
    List<FileEntity> getlikelyfile(String cid);
    
    //�û��ļ���ҳ
    List<FileEntity> findByUserAndPage(int userid,int page,int rowsperpage);
    
    int getPageNumByUser(int userid,int rowsperpage);
    
    int getFileNumByUser(int userid);
    
    //��ȡ�ļ�����
    int getFileTotalNum();
    
    
}
