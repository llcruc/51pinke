package com.service;

public interface CategoryService {
	/**
	 * ��ȡ������
	 * @param cid
	 * @return
	 */
	String getNameById(String cid);
	
	/**
	 * ��ȡ��һ����Ŀ
	 * @param cid
	 * @return
	 */
	String getFirst(String cid);
	
	/**
	 * ��ȡ�ڶ�����Ŀ
	 * @param cid
	 * @return
	 */
	String getSecond(String cid);
}
