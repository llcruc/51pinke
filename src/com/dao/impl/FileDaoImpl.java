package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.file.dao.FileDao;
import com.spring.entity.FileEntity;

public class FileDaoImpl implements FileDao{
	
    private SessionFactory sessionFactory;          //定义持久操作所需要的会话工厂
	
    //设置sessionfactory依赖注入
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void uploadfile(FileEntity file) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(file);
		session.getTransaction().commit();
		
	}

	@Override
	public FileEntity getfileById(int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hsql="from FileEntity file where file.fileid=?";
		Query query=session.createQuery(hsql);
		query.setInteger(0, fileid);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		FileEntity fileEntity=new FileEntity();
		if(list.size()!=0){
			fileEntity=list.get(0);
		}
		session.getTransaction().commit();
		return fileEntity;
	}

	@Override
	public void update(FileEntity file) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(file);
		session.getTransaction().commit();
	}

	@Override
	public void delete(int fileid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hsql="from FileEntity file where file.fileid=?";
		Query query=session.createQuery(hsql);
		query.setInteger(0, fileid);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		if(list.size()!=0){
			session.delete(list.get(0));
		}
		session.getTransaction().commit();
	}

	@Override
	public List<FileEntity> getfileByUser(int userid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hsql="from FileEntity file where file.userid=? order by uploadtime desc";
		Query query=session.createQuery(hsql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public FileEntity getfileByUserAndId(int userid, String uploadtime) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hsql="from FileEntity file where file.userid=? and file.uploadtime=?";
		Query query=session.createQuery(hsql);
		query.setInteger(0, userid);
		query.setString(1, uploadtime);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		if(list.size()!=0){
			FileEntity fileEntity=new FileEntity();
			fileEntity=list.get(0);
			session.getTransaction().commit();
			return fileEntity;
		}else {
			FileEntity fileEntity=new FileEntity();
			session.getTransaction().commit();
			return fileEntity;
		}
	}

	@Override
	public List<FileEntity> searchfile(String word, int page, int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileEntity f where f.filename like ? order by f.uploadtime desc";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getfilepageNum(String word, int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileEntity f where f.filename like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		session.getTransaction().commit();
		rows=list.size();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage+1;
		}
	}

	@Override
	public int getfileNum(String word) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileEntity f where f.filename like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+word+"%");
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		session.getTransaction().commit();
		return list.size();
	}

	@Override
	public List<FileEntity> getlikelyfile(String cid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileEntity f where f.category=? order by f.downloadtimes desc";
		Query query=session.createQuery(hql);
		query.setString(0, cid);
		query.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<FileEntity> findByUserAndPage(int userid, int page,
			int rowsperpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileEntity f where f.userid=? order by f.uploadtime desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		query.setMaxResults(rowsperpage);
		query.setFirstResult((page-1)*rowsperpage);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getPageNumByUser(int userid, int rowsperpage) {
		// TODO Auto-generated method stub
		int rows=0;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileEntity f where f.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		rows=list.size();
		session.getTransaction().commit();
		if(rows%rowsperpage==0){
			return rows/rowsperpage;
		}else {
			return rows/rowsperpage+1;
		}
	}

	@Override
	public int getFileNumByUser(int userid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileEntity f where f.userid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		session.getTransaction().commit();
		return list.size();
	}

	@Override
	public int getFileTotalNum() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from FileEntity";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<FileEntity> list=query.list();
		session.getTransaction().commit();
		return list.size();
	}

}
