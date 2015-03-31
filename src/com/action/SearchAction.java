package com.action;

import java.util.List;




import bsh.This;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RucTeacherService;
import com.service.SearchService;
import com.spring.entity.FileEntity;
import com.spring.entity.RucCourse;
import com.spring.entity.RucTeacher;

/**
 * ËÑË÷Action
 * @author Flyaway
 *
 */
public class SearchAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private SearchService searchService;
	private RucTeacherService rucTeacherService;
	
	private int pageNum;
	private int page=1;
	private int rowsperpage;
	private int num=0;
	
	private String word;
	private List<FileEntity> filelist;
	private FileEntity file;
	private List<RucCourse> rucCourseslist;
	private RucCourse rucCourse;
	private List<RucTeacher> rucTeacherlist;
	private RucTeacher rucTeacher;
	
	private int filenum;
	private int coursenum;
	private int teachernum;
	
	/**
	 * ¼ìË÷½ÌÊ¦
	 */
	public String searchteacher(){
		try {
			ActionContext context=ActionContext.getContext();
			this.setPageNum(searchService.getteacherpageNum(word, rowsperpage));
			this.setRucTeacherlist(searchService.searchteacher(word, page, rowsperpage));
			this.setNum(searchService.getTeacherNum(word));
			context.put("page", page);
			context.put("pageNum", pageNum);
			context.put("word", word);
			return "teacherresult";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	
	/**
	 * ¼ìË÷ÎÄ¼þ
	 * @return
	 */
	public String searchfile(){
		try {
			ActionContext context=ActionContext.getContext();
			this.setPageNum(searchService.getfilepageNum(word, rowsperpage));
			this.setFilelist(searchService.searchfile(word, page, rowsperpage));
			this.setNum(searchService.getfileNum(word));
			context.put("page", page);
			context.put("pageNum", pageNum);
			context.put("word", word);
			return "fileresult";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
	}
	
	/**
	 * ¼ìË÷¿Î³Ì
	 * @return
	 */
	public String searchcourse(){
		try {
			ActionContext context=ActionContext.getContext();
			this.setPageNum(searchService.getcoursepageNum(word, rowsperpage));
			this.setRucCourseslist(searchService.seaechcourse(word, page, rowsperpage));
			this.setNum(searchService.getcourseNum(word));
			context.put("page", page);
			context.put("pageNum", pageNum);
			context.put("word", word);
			return "courseresult";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	

	public String search(){
		    this.setFilenum(searchService.getfileNum(word));
		    this.setCoursenum(searchService.getcourseNum(word));
		    this.setTeachernum(searchService.getTeacherNum(word));
			return "result";
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public List<FileEntity> getFilelist() {
		return filelist;
	}
	public void setFilelist(List<FileEntity> filelist) {
		this.filelist = filelist;
	}
	public FileEntity getFile() {
		return file;
	}
	public void setFile(FileEntity file) {
		this.file = file;
	}
	public List<RucCourse> getRucCourseslist() {
		return rucCourseslist;
	}
	public void setRucCourseslist(List<RucCourse> rucCourseslist) {
		this.rucCourseslist = rucCourseslist;
	}
	public RucCourse getRucCourse() {
		return rucCourse;
	}
	public void setRucCourse(RucCourse rucCourse) {
		this.rucCourse = rucCourse;
	}
	public List<RucTeacher> getRucTeacherlist() {
		return rucTeacherlist;
	}
	public void setRucTeacherlist(List<RucTeacher> rucTeacherlist) {
		this.rucTeacherlist = rucTeacherlist;
	}
	public RucTeacher getRucTeacher() {
		return rucTeacher;
	}
	public void setRucTeacher(RucTeacher rucTeacher) {
		this.rucTeacher = rucTeacher;
	}
	public SearchService getSearchService() {
		return searchService;
	}
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}


	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRowsperpage() {
		return rowsperpage;
	}
	public void setRowsperpage(int rowsperpage) {
		this.rowsperpage = rowsperpage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getFilenum() {
		return filenum;
	}

	public void setFilenum(int filenum) {
		this.filenum = filenum;
	}

	public int getCoursenum() {
		return coursenum;
	}

	public void setCoursenum(int coursenum) {
		this.coursenum = coursenum;
	}

	public RucTeacherService getRucTeacherService() {
		return rucTeacherService;
	}

	public void setRucTeacherService(RucTeacherService rucTeacherService) {
		this.rucTeacherService = rucTeacherService;
	}


	public int getTeachernum() {
		return teachernum;
	}


	public void setTeachernum(int teachernum) {
		this.teachernum = teachernum;
	}
	
	
	

}
