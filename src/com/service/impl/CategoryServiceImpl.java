package com.service.impl;

import com.file.dao.CategoryDao;
import com.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDao categoryDao;

	@Override
	public String getNameById(String cid) {
		// TODO Auto-generated method stub
		return categoryDao.getNameById(cid);
	}
	
	public String getFirst(String cid){
		cid=cid.substring(0,cid.indexOf(","));
		return categoryDao.getNameById(cid);
	}

	@Override
	public String getSecond(String cid) {
		// TODO Auto-generated method stub
		cid=cid.substring(0,cid.lastIndexOf(","));
		return categoryDao.getNameById(cid);
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	

}
