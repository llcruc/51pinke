package com.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.service.FileService;
import com.service.UserService;
import com.service.User_log_Service;
import com.spring.entity.LoginLog;
import com.spring.entity.User;
import com.util.Jmail;
import com.util.MD5Encrypt;
import com.util.StringHandler;

/**
 * �û�����action
 * @author Flyaway
 *
 */
public class UserAction{
	
	
	private String mail;   //�û�����
	private String password;    //�û�����
	private String newpassword;   //������
	
	private String nickname;    //�û��ǳ�
	private String borndate;
	private String college;
	private String address;
	private int userid;
	

	private UserService userService;    //�û�ҵ���߼����
	private User_log_Service user_log_Service;   //��־ҵ���߼����
	private FileService fileService;
	
	
    public String logout(){
    	ActionContext context=ActionContext.getContext();
    	try {
    		context.getSession().clear();
    		return "logout";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
    	
    }
    /**
     * �û�������Ϣ�޸�
     * @return
     */
    public String userinfoedite(){
    	User user=new User();
    	ActionContext context=ActionContext.getContext();
    	this.setUserid(((User)context.getSession().get("user")).getUserid());
    	user=userService.findUserById(userid);
    	user.setCollege(college);
    	user.setBorndate(borndate);
    	user.setAddress(address);
    	user.setNickname(nickname);
    	try {
			userService.updateUser(user);
			context.getSession().put("user", user);
			return "userinfopage";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
    }
	
	/**
	 * �û���¼
	 * @return
	 * @throws IOException 
	 */
	public String login() throws IOException{
		ActionContext context=ActionContext.getContext();
		
		HttpServletRequest request=ServletActionContext.getRequest(); //��ȡҳ��request����
		HttpServletResponse response=ServletActionContext.getResponse();  //��ȡҳ��response����
		response.setContentType("text/xml;charset=UTF-8");     //���÷�����������
		response.setHeader("Cache-Control", "no-cache");   //����IE����
		String login_ip=request.getRemoteAddr();    //��ȡ��¼ip
		Date date=new Date();
		String date_string=StringHandler.timeTostr(date);   //��¼ʱ��
		User user=userService.getUser(mail);
		context.put("mail", mail);
		if(user.getMail()!=null){
			if(MD5Encrypt.encode(password).equals(user.getPassword())){
				LoginLog loginLog=new LoginLog();
				loginLog.setLogin_ip(login_ip);
				loginLog.setUserid(user.getUserid());
				loginLog.setLogin_datetime(date_string);
				user.setLastip(login_ip);
				user.setLastvisite(date_string);
				userService.updateUser(user);
				user_log_Service.sava(loginLog);
				context.getSession().put("user", user);
				return "loginsuccess";
			}else{
				context.put("loginmsg", "�������");
				return "login";
			}
		}else {
			context.put("loginmsg", "�û��������ڣ�");
			return "login";
		}
	}
	
	/**
	 * �û���¼
	 * @return
	 * @throws IOException 
	 */
	public String login2() throws IOException{
		ActionContext context=ActionContext.getContext();
		
		HttpServletRequest request=ServletActionContext.getRequest(); //��ȡҳ��request����
		HttpServletResponse response=ServletActionContext.getResponse();  //��ȡҳ��response����
		response.setContentType("text/xml;charset=UTF-8");     //���÷�����������
		response.setHeader("Cache-Control", "no-cache");   //����IE����
		String login_ip=request.getRemoteAddr();    //��ȡ��¼ip
		Date date=new Date();
		String date_string=StringHandler.timeTostr(date);   //��¼ʱ��
		User user=userService.getUser(mail);
		context.put("mail", mail);
		if(user.getMail()!=null){
			if(MD5Encrypt.encode(password).equals(user.getPassword())){
				LoginLog loginLog=new LoginLog();
				loginLog.setLogin_ip(login_ip);
				loginLog.setUserid(user.getUserid());
				loginLog.setLogin_datetime(date_string);
				user.setLastip(login_ip);
				user.setLastvisite(date_string);
				userService.updateUser(user);
				user_log_Service.sava(loginLog);
				context.getSession().put("user", user);
				return "loginsuccess2";
			}else{
				context.put("loginmsg", 1);
				return "login2";
			}
		}else {
			context.put("loginmsg", 2);
			return "login2";
		}
	}
	
	/**
	 * �û�ע��
	 * @return
	 * @throws IOException 
	 */
	public String registe() throws IOException{
		ActionContext context=ActionContext.getContext();
		User user=new User();
		user=userService.getUser(mail);
		Date date=new Date();
		String date_string=StringHandler.timeTostr(date);
		MD5Encrypt md5Encrypt=new MD5Encrypt();
		if(user.getMail()!=null){
			return "error";
		}else{
			if(md5Encrypt.isValidInput(password)){
				password=MD5Encrypt.encode(password);
			    user.setMail(mail);
			    user.setPassword(password);
			    user.setRegistedate(date_string);
			    user.setCredit(100);
			    user.setGender(0);
			    user.setNickname(nickname);
			    userService.savaUser(user);
			    user=userService.getUser(mail);
				String path=ServletActionContext.getServletContext().getRealPath("/data")+"\\user\\"+user.getUserid();
				File file=new File(path);
				if(!file.exists()){
					file.mkdir();
					String path2=file.getPath()+"\\filedata";
					String path3=file.getPath()+"\\userinfo";
					new File(path2).mkdir();
					new File(path3).mkdir();
				}
			    String message="http://www.51pink.net/user!active.action?id="+user.getUserid()+"&pwd="+user.getPassword();
			    context.getSession().put("user", user);
			    Jmail jmail=new Jmail();
			    jmail.sendmail(user.getMail(), message);
			    return "registe";
			}else {
				return "error";
			}
		}
	}
	
	/**
	 * ��֤�û���
	 * @return
	 * @throws IOException 
	 */
	public String validatemail() throws IOException{
		System.out.println(mail);
		User user=new User();
		user=userService.getUser(mail);
		HttpServletResponse response=ServletActionContext.getResponse();  //��ȡҳ��response����
		response.setContentType("text/xml;charset=UTF-8");     //���÷�����������
		response.setHeader("Cache-Control", "no-cache");   //����IE����
		if(user.getMail()!=null){
			System.out.println("no");
			response.getWriter().print("<info>error</info>");
			return null;
		}else {
			response.getWriter().print("<info>success</info>");
			return null;
		}
	}
	
	/**
	 * �û��޸�����
	 * @return
	 */
	public String updatepassword(){
		MD5Encrypt md5Encrypt=new MD5Encrypt();
		User user=userService.getUser(mail);
		if(user.getPassword().equals(MD5Encrypt.encode(password)) && md5Encrypt.isValidInput(newpassword)){
			newpassword=MD5Encrypt.encode(newpassword);
			user.setPassword(newpassword);
			userService.updateUser(user);
			return "success";
		}else {
			return "error";
		}
	}
	
	/**
	 * �û����¸�����Ϣ
	 * @return
	 */
	public String updateUserinfo(){
		User user=userService.getUser(mail);
		user.setNickname(nickname);
		userService.updateUser(user);
		return "success";
	}
	

	

	//spring����ע�뷽��
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setUser_log_Service(User_log_Service user_log_Service) {
		this.user_log_Service = user_log_Service;
	}
	
	//����setter��getter
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBorndate() {
		return borndate;
	}

	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public UserService getUserService() {
		return userService;
	}

	public User_log_Service getUser_log_Service() {
		return user_log_Service;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

}
