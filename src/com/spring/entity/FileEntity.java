package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �ϴ��ļ�ʵ��
 * @author Flyaway
 *
 */
@Entity
@Table(name="t_file")
public class FileEntity {
	//�ĵ�id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fileid")
	private String fileid;
	//�ļ�������
	@Column(name="userid")
	private int userid;
	//�ĵ�����
	@Column(name="title")
	private String title;
	//�ļ���
	@Column(name="filename")
	private String filename;
	//�ĵ�����
	@Column(name="introduction")
	private String introduction;
	//�ĵ�����
	@Column(name="categoryid")
	private String category;
	//�ĵ���ǩ
	@Column(name="tips")
	private String tips;
	//�ĵ�����
	@Column(name="ispublic")
	private int ispublic;
	//�ĵ��ۼ�
	@Column(name="fileprice")
	private int fileprice;
	//�ļ�����
	@Column(name="filetype")
	private String filetype;
	//�ļ���С
	@Column(name="filesize")	
	private int filesize;
	//�ļ��ϴ�ʱ��
	@Column(name="uploadtime")
	private String uploadtime;
	//�ļ�����
	@Column(name="score")
	private double score;
	//�ļ����ִ���
	@Column(name="scoretimes")
	private int scoretimes;
	//�ļ������ش���
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
