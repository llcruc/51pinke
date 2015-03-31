package com.action;

import java.util.List;







import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FileCollectionService;
import com.service.FileDownLogService;
import com.service.FileService;
import com.service.RucCourseService;
import com.service.RucTeacherService;
import com.service.UserService;
import com.spring.entity.FileCollection;
import com.spring.entity.FileDownLog;
import com.spring.entity.FileEntity;
import com.spring.entity.RucCourse;
import com.spring.entity.User;

/**
 * ��ҳ������Ŀ����ת
 * @author Flyaway
 *
 */
public class MainAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FileService fileService;
	private FileDownLogService fileDownLogService;
	private FileCollectionService fileCollectionService;
	private UserService userService;
	private RucTeacherService rucTeacherService;
	
	private List<FileEntity> fileList;
	private int filepageNow;
	private int filepageNum;
	private int fileNum;
	private int userid;
	
	private List<FileDownLog> filedownlist;
	private FileDownLog fileDownLog;
	private int downlogpage;
	private int downlogpageNum;
	
	
	private int cid;
	private String coursecategory;
	private RucCourseService rucCourseService;
	private int pageNum;
	private List<RucCourse> list;
	private int dataNum;    //��������
	private int rowsperpage=10;  //ÿҳ����
	private int pageNow=1;  //��ǰҳ
	private RucCourse rucCourse;
	
	private List<FileCollection> fileCollectionList;
	private FileCollection fileCollection;
	private int collectpage;
	private int collectpageNum;
	

	
	public String userdownfilelist(){
		ActionContext context=ActionContext.getContext();
		this.setRowsperpage(10);
		int userid=((User)context.getSession().get("user")).getUserid();
		filedownlist=fileDownLogService.findByUserAndPage(userid, downlogpage, rowsperpage);
		downlogpageNum=fileDownLogService.getPageNum(userid, rowsperpage);
		dataNum=fileDownLogService.getDataNum(userid);
		context.put("page", downlogpage);
		context.put("pageNum1", downlogpageNum);
		return "downloglist";
	}
	
	public String usercollectlist(){
		ActionContext context=ActionContext.getContext();
		int userid=((User)context.getSession().get("user")).getUserid();
		this.setRowsperpage(10);
		fileCollectionList=fileCollectionService.findByUseridAndPage(userid, collectpage, rowsperpage);
		collectpageNum=fileCollectionService.getPageNumByUser(userid, rowsperpage);
		dataNum=fileCollectionService.getDataNumByUser(userid);
		context.put("page", collectpage);
		context.put("pageNum1", collectpageNum);
		return "usercollectlist";
	}
	
	public String usercollectlist2(){
		ActionContext context=ActionContext.getContext();
		this.setRowsperpage(5);
		int userid=((User)context.getSession().get("user")).getUserid();
		fileCollectionList=fileCollectionService.findByUseridAndPage(userid, collectpage, rowsperpage);
		collectpageNum=fileCollectionService.getPageNumByUser(userid, rowsperpage);
		dataNum=fileCollectionService.getDataNumByUser(userid);
		context.put("page", collectpage);
		context.put("pageNum1", collectpageNum);
		return "usercollectlist2";
	}
	
	
	public String userfilelist(){
		ActionContext context=ActionContext.getContext();
		this.setRowsperpage(5);
		fileList=fileService.findByUserAndPage(userid, filepageNow, rowsperpage);
		filepageNum=fileService.getPageNumByUser(userid, rowsperpage);
		fileNum=fileService.getFileNumByUser(userid);
		context.put("page", filepageNow);
		context.put("pageNum1", filepageNum);
		return "userfilelist";
	}
	
	public String userfilelist2(){
		ActionContext context=ActionContext.getContext();
		this.setRowsperpage(10);
		fileList=fileService.findByUserAndPage(userid, filepageNow, rowsperpage);
		filepageNum=fileService.getPageNumByUser(userid, rowsperpage);
		fileNum=fileService.getFileNumByUser(userid);
		context.put("page", filepageNow);
		context.put("pageNum1", filepageNum);
		return "userfilelist2";
	}
	

	public String maincourse(){
		this.setRowsperpage(10);
		try {
			ActionContext context=ActionContext.getContext();
			switch(cid){
			case 1:coursecategory="ͨʶ��������";break;
			case 2:coursecategory="ȫУ��ͬ��";break;
			case 3:coursecategory="����������";break;
			case 4:coursecategory="ԭ��ѡ����";break;
			case 5:coursecategory="Ӧ�û���";break;
			case 6:coursecategory="������";break;
			case 7:coursecategory="������";break;
			case 8:coursecategory="������";break;
			case 9:coursecategory="����";break;
			case 10:coursecategory="רҵ����";break;
			case 11:coursecategory="רҵѡ��";break;
			}
			System.out.println(coursecategory+"1");
			pageNum=rucCourseService.getPageNum(coursecategory, rowsperpage);
			context.put("pageNow", pageNow);
			context.put("pageNum", pageNum);
			context.put("cid", cid);
			list=rucCourseService.getCourseByPage(coursecategory, pageNow, rowsperpage);
			dataNum=rucCourseService.getDataNum(coursecategory);
			return "maincourse";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCoursecategory() {
		return coursecategory;
	}

	public void setCoursecategory(String coursecategory) {
		this.coursecategory = coursecategory;
	}

	public RucCourseService getRucCourseService() {
		return rucCourseService;
	}

	public void setRucCourseService(RucCourseService rucCourseService) {
		this.rucCourseService = rucCourseService;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<RucCourse> getList() {
		return list;
	}

	public void setList(List<RucCourse> list) {
		this.list = list;
	}

	public int getDataNum() {
		return dataNum;
	}

	public void setDataNum(int dataNum) {
		this.dataNum = dataNum;
	}

	public int getRowsperpage() {
		return rowsperpage;
	}

	public void setRowsperpage(int rowsperpage) {
		this.rowsperpage = rowsperpage;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public RucCourse getRucCourse() {
		return rucCourse;
	}

	public void setRucCourse(RucCourse rucCourse) {
		this.rucCourse = rucCourse;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public List<FileEntity> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileEntity> fileList) {
		this.fileList = fileList;
	}

	public int getFilepageNow() {
		return filepageNow;
	}

	public void setFilepageNow(int filepageNow) {
		this.filepageNow = filepageNow;
	}

	public int getFilepageNum() {
		return filepageNum;
	}

	public void setFilepageNum(int filepageNum) {
		this.filepageNum = filepageNum;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getFileNum() {
		return fileNum;
	}
	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public FileDownLogService getFileDownLogService() {
		return fileDownLogService;
	}

	public void setFileDownLogService(FileDownLogService fileDownLogService) {
		this.fileDownLogService = fileDownLogService;
	}

	public List<FileDownLog> getFiledownlist() {
		return filedownlist;
	}

	public void setFiledownlist(List<FileDownLog> filedownlist) {
		this.filedownlist = filedownlist;
	}

	public FileCollectionService getFileCollectionService() {
		return fileCollectionService;
	}

	public void setFileCollectionService(FileCollectionService fileCollectionService) {
		this.fileCollectionService = fileCollectionService;
	}

	public List<FileCollection> getFileCollectionList() {
		return fileCollectionList;
	}

	public void setFileCollectionList(List<FileCollection> fileCollectionList) {
		this.fileCollectionList = fileCollectionList;
	}
	public int getCollectpage() {
		return collectpage;
	}
	public void setCollectpage(int collectpage) {
		this.collectpage = collectpage;
	}
	public int getCollectpageNum() {
		return collectpageNum;
	}
	public void setCollectpageNum(int collectpageNum) {
		this.collectpageNum = collectpageNum;
	}

	public FileCollection getFileCollection() {
		return fileCollection;
	}
	public void setFileCollection(FileCollection fileCollection) {
		this.fileCollection = fileCollection;
	}

	public FileDownLog getFileDownLog() {
		return fileDownLog;
	}

	public void setFileDownLog(FileDownLog fileDownLog) {
		this.fileDownLog = fileDownLog;
	}

	public int getDownlogpage() {
		return downlogpage;
	}

	public void setDownlogpage(int downlogpage) {
		this.downlogpage = downlogpage;
	}

	public int getDownlogpageNum() {
		return downlogpageNum;
	}

	public void setDownlogpageNum(int downlogpageNum) {
		this.downlogpageNum = downlogpageNum;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RucTeacherService getRucTeacherService() {
		return rucTeacherService;
	}

	public void setRucTeacherService(RucTeacherService rucTeacherService) {
		this.rucTeacherService = rucTeacherService;
	}
}
