package com.action;


import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.service.CourseTableService;
import com.service.FileDownLogService;
import com.service.FileService;
import com.service.UserService;
import com.spring.entity.FileEntity;
import com.spring.entity.User;
/**
 * ��ҳ��תaction
 * @author Flyaway
 *
 */

public class DispatchAction {
	private String page;
	
	private UserService userService;
	private FileService fileService;
	private CourseTableService courseTableService;
	private FileDownLogService fileDownLogService;
	
	private User user;
	
	private int filenum;
	private int userdown;
	private int userfiledown;
	
	private int filetotalnum;
	
	private FileEntity fileEntity;
	private int fileid;
	
	
	//ע��ҳ��
	public String registepage(){
		return "registe";
	}

	
	//��ҳ�ļ�����ҳ��
	public String filenum(){
		try {

			this.setFiletotalnum(fileService.getFileTotalNum());
			return "filenum";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//��¼ҳ��
	public String loginpage(){
		return "login";
	}
	
	public String loginpage2(){
		return "logined";
	}
	
	public String loginpage3(){
		return "checklogin";
	}
	
	//�ϴ�ҳ��
	public String uploadpage(){
		return "upload";
	}
	//�û���������
	public String userpage(){
		ActionContext context=ActionContext.getContext();
		int userid=((User)context.getSession().get("user")).getUserid();
		this.setUser(userService.findUserById(userid));
		this.setFilenum(fileService.getFileNumByUser(userid));
		List<FileEntity> list=fileService.getfileByUser(userid);
		userfiledown=0;
		for(int i=0;i<list.size();i++){
			userfiledown+=list.get(i).getDownloadtimes();
		}
		return "user";
	}
	//�û�����
	public String userinfo(){
		return "userinfo";
	}
	//�޸�ͷ��
	public String editeicon(){
		return "editeicon";
	}
	//�޸ĸ�������
	public String editeuserinfo(){
		int userid=26;
		this.setUser(userService.findUserById(userid));
		return "editeuserinfo";
	}
	//�û��ĵ�ҳ��
	public String userfile(){
		return "userfile";
	}
	//�û��޸��ĵ�ҳ��
	public String userfileedite(){
		fileEntity=fileService.getfileById(fileid);
		return "editefile";
	}
	//�û��γ�
	public String usercourse(){
		int userid=26;
		if(courseTableService.getCourseByUser(userid).size()==0){
		    return "usercourse";
		}else{
			return "usercoursetable";
		}
	}
	
	//�û��ղ�
	public String collect(){
		return "collect";
	}
	
	//�û�����
	public String mydownload(){
		return "mydownload";
	}
	//�û�����
	public String usercredit(){
		return "usercredit";
	}
	
	//�γ���
	public String ruccourse(){
		return "ruccourse";
	}

	public CourseTableService getCourseTableService() {
		return courseTableService;
	}
	
	public void setCourseTableService(CourseTableService courseTableService) {
		this.courseTableService = courseTableService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public int getFilenum() {
		return filenum;
	}

	public void setFilenum(int filenum) {
		this.filenum = filenum;
	}

	public FileDownLogService getFileDownLogService() {
		return fileDownLogService;
	}

	public void setFileDownLogService(FileDownLogService fileDownLogService) {
		this.fileDownLogService = fileDownLogService;
	}

	public int getUserdown() {
		return userdown;
	}

	public void setUserdown(int userdown) {
		this.userdown = userdown;
	}

	public int getUserfiledown() {
		return userfiledown;
	}

	public void setUserfiledown(int userfiledown) {
		this.userfiledown = userfiledown;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getFiletotalnum() {
		return filetotalnum;
	}

	public void setFiletotalnum(int filetotalnum) {
		this.filetotalnum = filetotalnum;
	}


	public FileEntity getFileEntity() {
		return fileEntity;
	}


	public void setFileEntity(FileEntity fileEntity) {
		this.fileEntity = fileEntity;
	}


	public int getFileid() {
		return fileid;
	}


	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

}
