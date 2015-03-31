package com.service;

public interface CategoryService {
	/**
	 * 获取分类名
	 * @param cid
	 * @return
	 */
	String getNameById(String cid);
	
	/**
	 * 获取第一个类目
	 * @param cid
	 * @return
	 */
	String getFirst(String cid);
	
	/**
	 * 获取第二个类目
	 * @param cid
	 * @return
	 */
	String getSecond(String cid);
}
