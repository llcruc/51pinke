package com.service;

import java.util.List;

import com.spring.entity.FileEntity;

/**
 * �û��ϴ��ĵ������ӿ�
 * @author Flyaway
 *
 */
public interface FileService {
	

    /**
     * �ϴ��ĵ�������Ϣ
     * @param file �ļ�ʵ��
     */
	public void uploadfile(FileEntity file);
	
	/**
	 * �����ļ���Ϣ
	 * @param file �ļ�ʵ��
	 */
	public void updatefile(FileEntity file);
	
	/**
	 * ����id�Ż�ȡ�ļ���Ϣ
	 * @param fileid �ļ�id
	 * @return
	 */
	public FileEntity getfileById(int fileid);
	
	/**
	 * �����û����ļ��ϴ�ʱ���ȡ�ļ�ID
	 * @param userid �û�id
	 * @param uploadtime �ļ��ϴ�ʱ��
	 * @return
	 */
	public FileEntity getfileByUserAndTime(int userid,String uploadtime);
	
	/**
	 * ��ȡ�û�ȫ��id
	 * @param userid �û�id
	 * @return
	 */
	public List<FileEntity> getfileByUser(int userid);
	
	/**
	 * ɾ���ļ�
	 * @param fileid �ļ�id
	 */
	public void delete(int fileid);
	
	/**
	 * ��ȡͬ����Ƽ��ĵ�
	 * @param cid
	 * @return
	 */
	List<FileEntity> getlikelyfile(String cid);
	
	/**
	 * �����û�id��ȡ��ҳ�ļ�
	 * @param userid
	 * @param page
	 * @param rowsperpage
	 * @return
	 */
    List<FileEntity> findByUserAndPage(int userid,int page,int rowsperpage);
    
    /**
     * �����û�id��ȡҳ��
     * @param userid
     * @param rowsperpage
     * @return
     */
    int getPageNumByUser(int userid,int rowsperpage);
    
    /**
     * �����û�di��ȡ�ļ���
     * @param userid
     * @return
     */
    int getFileNumByUser(int userid);
    
    /**
     * ��ȡ�ļ�����
     * @return
     */
    int getFileTotalNum();

}
