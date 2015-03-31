package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 上传文件实体
 * @author Flyaway
 *
 */
@Entity
@Table(name="t_file")
public class FileEntity {
	//文档id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fileid")
	private String fileid;
	//文件所有者
	@Column(name="userid")
	private int userid;
	//文档标题
	@Column(name="title")
	private String title;
	//文件名
	@Column(name="filename")
	private String filename;
	//文档描述
	@Column(name="introduction")
	private String introduction;
	//文档分类
	@Column(name="categoryid")
	private String category;
	//文档标签
	@Column(name="tips")
	private String tips;
	//文档类型
	@Column(name="ispublic")
	private int ispublic;
	//文档售价
	@Column(name="fileprice")
	private int fileprice;
	//文件类型
	@Column(name="filetype")
	private String filetype;
	//文件大小
	@Column(name="filesize")	
	private int filesize;
	//文件上传时间
	@Column(name="uploadtime")
	private String uploadtime;
	//文件评分
	@Column(name="score")
	private double score;
	//文件评分次数
	@Column(name="scoretimes")
	private int scoretimes;
	//文件被下载次数
	@Column(name="downloadtimes")
	private int downloadtimes;
	
	private int browsetimes;
	
	
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getIspublic() {
		return ispublic;
	}
	public void setIspublic(int ispublic) {
		this.ispublic = ispublic;
	}
	public int getFileprice() {
		return fileprice;
	}
	public void setFileprice(int fileprice) {
		this.fileprice = fileprice;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getScoretimes() {
		return scoretimes;
	}
	public void setScoretimes(int scoretimes) {
		this.scoretimes = scoretimes;
	}
	public int getDownloadtimes() {
		return downloadtimes;
	}
	public void setDownloadtimes(int downloadtimes) {
		this.downloadtimes = downloadtimes;
	}

	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public int getBrowsetimes() {
		return browsetimes;
	}
	public void setBrowsetimes(int browsetimes) {
		this.browsetimes = browsetimes;
	}
	
	
	
	

}
