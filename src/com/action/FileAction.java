package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CategoryService;
import com.service.FileCollectionService;
import com.service.FileCommentService;
import com.service.FileDownLogService;
import com.service.FileScoreService;
import com.service.FileService;
import com.service.UserService;
import com.spring.entity.FileCollection;
import com.spring.entity.FileComment;
import com.spring.entity.FileDownLog;
import com.spring.entity.FileEntity;
import com.spring.entity.FileScore;
import com.spring.entity.User;
import com.util.DocConverter;
import com.util.StringHandler;

/**
 * 文件操作Action
 * @author Flyaway
 *
 */
public class FileAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private FileService fileService;
	private CategoryService categoryService;
	private UserService userService;
	private FileScoreService fileScoreService;
	private FileCommentService fileCommentService;
	private FileDownLogService fileDownLogService;
	private FileCollectionService fileCollectionService;
	
	
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	private User user;
	private int userid1;
	
	private int rowsperpage;
	
	//文件标题
	private String title;
	//文档介绍
	private String introduction;
	//文档标签
	private String tips;
	//文档分类
	private String category;
	//文档公开与否
	private int ispublic;
	//文档价格
	private int fileprice;
	//文档编号
	private int fileid;
	
	//swf路径
	private String swfpath;
	
	//文件实体
	private FileEntity fileEntity;
	
	//分类名
	private String categoryfirst;
	private String categorysecond;
	private String categoryname;
	
	//用户评分
	private int userscore;
	private double score;
	
	//文件下载
	private String downloadname;
	private InputStream inputStream1;
	
	//相似文档推荐
	private List<FileEntity> likelylist;
	
	//用户评论
	private List<FileComment> commentlist;
	private String comment;
	private FileComment fileComment;
	private int commentuserid;
	private int cpage;
	private int cpageNum;
	private int cdatanum;
	
	
	
	/**
	 * 用户收藏文件
	 * @return
	 */
	public String filecollect(){
		ActionContext context=ActionContext.getContext();
		int userid=((User)context.getSession().get("user")).getUserid();
		try {
			FileCollection fileCollection=new FileCollection();
			fileCollection.setUserid(userid);
			fileCollection.setFileid(fileid);
			fileCollection.setDatetime(StringHandler.timeTostr(new Date()));
			fileCollectionService.save(fileCollection);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	
	/**
	 * 加载评论
	 * @return
	 */
	public String loadcomment(){
		ActionContext context=ActionContext.getContext();
		this.setCommentlist(fileCommentService.findByPage(fileid, cpage, rowsperpage));
		this.setCpageNum(fileCommentService.getPageNum(fileid, rowsperpage));
		this.setCdatanum(fileCommentService.getDataNum(fileid));
		context.put("page", cpage);
		context.put("pageNum", cpageNum);
		System.out.println(fileid);
		System.out.println(commentlist.size());
		return "loadcomment";
	}
	
	/**
	 * 新评论
	 * @return
	 * @throws IOException
	 */
	public String newcomment() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();  //获取页面response对象
		response.setContentType("text/xml;charset=UTF-8");     //设置返回内容类型
		response.setHeader("Cache-Control", "no-cache");   //禁用IE缓存
		ActionContext context=ActionContext.getContext();
		User user=(User)context.getSession().get("user");
		FileComment fileComment=new FileComment();
		fileComment.setComment(comment);
		fileComment.setUserid(user.getUserid());
		fileComment.setCommentdate(StringHandler.timeTostr(new Date()));
		fileComment.setFileid(fileid);
		try {
			fileCommentService.save(fileComment);
			response.getWriter().print("<msg>success</msg>");
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.getWriter().print("<msg>error</msg>");
			return null;
		}
	}
	
	/**
	 * 文件评分
	 * @return
	 */
	public String filescore(){
		ActionContext context=ActionContext.getContext();
		int userid=((User)context.getSession().get("user")).getUserid();
		try {
			FileScore fileScore=new FileScore();
			fileScore.setDatetime(StringHandler.timeTostr(new Date()));
			fileScore.setFileid(fileid);
			fileScore.setUserid(userid);
			fileScore.setUserscore(userscore);
			fileScoreService.score(fileScore);
			FileEntity fileEntity=new FileEntity();
			System.out.println(fileid);
			fileEntity=fileService.getfileById(fileid);
			int scoretimes=fileEntity.getScoretimes();
			score=fileEntity.getScore();
			score=(score*scoretimes+userscore)/(scoretimes+1);
			fileEntity.setScore(score);
			fileEntity.setScoretimes(scoretimes+1);
			fileService.updatefile(fileEntity);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 文件预览页面
	 * @return
	 */
	public String preview(){
		fileEntity=fileService.getfileById(this.getFileid());
		String cid=fileEntity.getCategory();
		this.setCategoryfirst(categoryService.getFirst(cid));
		this.setCategorysecond(categoryService.getSecond(cid));
		this.setCategoryname(categoryService.getNameById(cid));
		User user=userService.findUserById(fileEntity.getUserid());
		this.setLikelylist(fileService.getlikelyfile(cid));
        fileEntity.setBrowsetimes(fileEntity.getBrowsetimes()+1);
        fileService.updatefile(fileEntity);
		this.setUser(user);
		return "preview";
	}
	
    /**
     * 文件预览flexpaper
     * @return
     */
	public String flexpaper(){
		FileEntity fileEntity=new FileEntity();
		fileEntity=fileService.getfileById(this.getFileid());
		this.setFileEntity(fileEntity);
		int userid1=fileEntity.getUserid();
		String path=ServletActionContext.getServletContext().getRealPath("/data")+"\\user\\"+userid1+"\\filedata\\";
		String filerealname=StringHandler.getSerial(StringHandler.StringToDate(fileEntity.getUploadtime()))+fileEntity.getFilename();
		DocConverter docConverter=new DocConverter(path+filerealname);
		docConverter.conver(ServletActionContext.getServletContext().getRealPath("/util"));
		this.setSwfpath("/data/user/"+userid1+"/filedata/"+StringHandler.getSerial(StringHandler.StringToDate(fileEntity.getUploadtime()))+".swf");
		
		return "flexpaper";
	}
	
	/**
	 * 文件下载
	 * @return
	 */
	public String downfile(){
		ActionContext context=ActionContext.getContext();
		int userid1=((User)context.getSession().get("user")).getUserid();
		
		FileEntity fileEntity=new FileEntity();
		fileEntity=fileService.getfileById(this.getFileid());
		
		FileDownLog fileDownLog=new FileDownLog();
		fileDownLog=fileDownLogService.findByUserAndFile(userid1, this.getFileid());
		if(fileDownLog.getDownloadtime()==null){
			fileDownLog.setDownloadtime(StringHandler.timeTostr(new Date()));
			fileDownLog.setUserid(userid1);
			fileDownLog.setFileid(this.getFileid());
			
			User user=new User();
			user=userService.findUserById(userid1);
			User user2=new User();
			user2=userService.findUserById(fileEntity.getUserid());
			int credit=user.getCredit();
			int credit2=user2.getCredit();
		    int price=fileEntity.getFileprice();
		    if(credit-price<0){
		    	System.out.println("分被扣完了");
		    	return "nonecredit";
		    }else {
		    	fileDownLogService.save(fileDownLog);
		    	user.setCredit(credit-price);
		    	user2.setCredit(credit2+price);
		    	System.out.println(user.getCredit());
		    	userService.updateUser(user);
		    	userService.updateUser(user2);
		    	System.out.println("扣分了！");
				return "down";
			}
		}else {
			System.out.println("没有扣分");
			return "down";
		}
	}
	
	/**
	 * 文件下载流
	 * @return
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException 
	 */
	public InputStream getInputStream1(){
		try {
			FileEntity fileEntity=new FileEntity();
			fileEntity=fileService.getfileById(this.getFileid());
			
			int userid=fileEntity.getUserid();
			int downloadtimes=fileEntity.getDownloadtimes();
			this.setDownloadname(new String(fileEntity.getFilename().getBytes(),"iso8859-1"));
			fileEntity.setDownloadtimes(downloadtimes+1);
			String filename=StringHandler.getSerial(StringHandler.StringToDate(fileEntity.getUploadtime()))+fileEntity.getFilename();
			String dir=ServletActionContext.getServletContext().getRealPath("/data/user/"+userid+"/filedata");
			File file=new File(dir, filename);
			fileService.updatefile(fileEntity);
			if(file.exists()){
				this.inputStream1=new FileInputStream(file);
				return inputStream1;
			}else {
				System.out.println("file not exsite");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("file not exsite,something is error");
			e.printStackTrace();
			return null;
		}
		
	}

	

	/**
	 * 文件上传
	 * @return
	 * @throws IOException 
	 */
	public String uploadfile() throws IOException{
		FileEntity fileEntity=new FileEntity();
		
		String path=ServletActionContext.getServletContext().getRealPath("/data")+"/user/"+userid1+"/filedata";
		Date date=new Date();
		String datetime=StringHandler.timeTostr(date);
		//!
		int userid=userid1;
		
		HttpServletResponse response=ServletActionContext.getResponse();  //获取页面response对象
		response.setContentType("text/xml;charset=UTF-8");     //设置返回内容类型
		response.setHeader("Cache-Control", "no-cache");   //禁用IE缓存
		
		InputStream ins=null;
		OutputStream ous=null;
		
		
		if(file!=null){
			File filetemp=new File(new File(path), fileFileName);
			try {
				ins=new FileInputStream(file);
				ous=new FileOutputStream(filetemp);
				int filesize=ins.available();
				byte[] b=new byte[1024];
				int len=0;
				while((len=ins.read(b))>0){
					ous.write(b,0,len);
				}
				System.out.flush();
				ins.close();
				ous.close();
				if(filetemp.exists()){
					filetemp.renameTo(new File(path+"/"+StringHandler.getSerial(date)+fileFileName));
					fileEntity.setFilename(fileFileName);
					fileEntity.setTitle(fileFileName);
					fileEntity.setFilesize(filesize);
					fileEntity.setFiletype(fileFileName.substring(fileFileName.lastIndexOf(".")+1, fileFileName.length()));
					fileEntity.setUserid(userid);
					fileEntity.setUploadtime(datetime);
					System.out.println(fileFileName+filesize+fileContentType+userid+datetime);
					fileService.uploadfile(fileEntity);
					FileEntity fileEntity2=new FileEntity();
					fileEntity2=fileService.getfileByUserAndTime(userid, datetime);
					response.getWriter().print("<msg><info>success</info><filename>"+fileFileName.subSequence(0, fileFileName.indexOf("."))+"</filename><fileid>"+fileEntity2.getFileid()+"</fileid></msg>");
					return null;
				}else{
					response.getWriter().print("<info>error</info>");
					System.out.println("file not exists");
					return "error";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				response.getWriter().print("<info>error</info>");
				System.out.println("io error");
				return "error";
			}
		}else {
			response.getWriter().print("<info>error</info>");
			System.out.println("file is null");
			return "error";
		}
	}
	
	/**
	 * 用户上传头像
	 * @return
	 * @throws IOException
	 */
	public String uploadicon() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();  //获取页面response对象
		HttpServletRequest request=ServletActionContext.getRequest();
		String pic1=request.getParameter("pic1");
		response.setContentType("text/xml;charset=UTF-8");     //设置返回内容类型
		response.setHeader("Cache-Control", "no-cache");   //禁用IE缓存
		System.out.println(pic1);
		if(pic1!=null&&pic1!=""){
			try {
				ActionContext context=ActionContext.getContext();
				User user=userService.findUserById(((User)context.getSession().get("user")).getUserid());
				user.setUsericon(pic1);
				userService.updateUser(user);
				context.getSession().put("user", user);
				System.out.println("save success"+user.getUsericon());
				response.getWriter().print("{\"status\":1}");
				return null;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				response.getWriter().print("<msg><info>error</info></msg>");
				return "error";
			}
		}else {
			System.out.println("pic is null");
			response.getWriter().print("<msg><info>error</info></msg>");
			return "error";
		}
	}
	
	public String deletecollection(){
		FileCollection fileCollection=new FileCollection();
		ActionContext context=ActionContext.getContext();
		int userid=((User)context.getSession().get("user")).getUserid();
		List<FileCollection> list=fileCollectionService.findByUseridAndFileid(userid, fileid);
		if(list.size()!=0){
			fileCollection=list.get(0);
			try {
				fileCollectionService.delete(fileCollection);
				return "collectiondelete";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "error";
			}
		}else {
			return "collectiondelete";
		}
	}
	
	/**
	 * 删除文件
	 * @return
	 */
	public String filedelete(){
		FileEntity fileEntity=new FileEntity();
		fileEntity=fileService.getfileById(fileid);
		User user=new User();
		ActionContext context=ActionContext.getContext();
		user=(User)context.getSession().get("user");
		String path=ServletActionContext.getServletContext().getRealPath("/data")+"/user/"+user.getUserid()+"/filedata";
		System.out.println(user.getUserid()+"   "+fileEntity.getUserid());
		if(user!=null && fileEntity.getUserid()==user.getUserid()){
			String filename=StringHandler.getSerial(StringHandler.StringToDate(fileEntity.getUploadtime()))+fileEntity.getFilename();
			File file=new File(path,filename);
			System.out.println(file.getPath());
			if(file.exists()){
				file.delete();
			}
			String swfname=StringHandler.getSerial(StringHandler.StringToDate(fileEntity.getUploadtime()))+".swf";
			File file2=new File(path,swfname);
			if(file2.exists()){
				file2.delete();
			}
			try {
				fileService.delete(fileid);
				return "filedelete";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "error";
			}
		}else {
			System.out.println("用户没有登录");
			return "checklogin";
		}
	}
	
	/**
	 * 更新文件
	 * @return
	 */
	public String deletefile(){
		try {
			FileEntity fileEntity=fileService.getfileById(this.getFileid());
			fileEntity.setTips(tips);
			fileEntity.setTitle(title);
			fileEntity.setFileprice(fileprice);
			fileEntity.setIntroduction(introduction);
			fileEntity.setCategory(category);
			fileEntity.setIspublic(ispublic);
			fileService.updatefile(fileEntity);
			
			return "fileupdated";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
	}
	
	public String fileinfo(){
		FileEntity fileEntity=new FileEntity();
		fileEntity=fileService.getfileById(fileid);
		System.out.println(fileEntity.getFileid());
		fileEntity.setCategory(category);
		fileEntity.setTitle(title);
		fileEntity.setIntroduction(introduction);
		fileEntity.setTips(tips);
		fileEntity.setIspublic(ispublic);
		fileEntity.setFileprice(fileprice);
		try {
			fileService.updatefile(fileEntity);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	
	//fileservice注入
		public void setFileService(FileService fileService) {
			this.fileService = fileService;
		}
		
		//各种getter和setter
		public File getFile() {
			return file;
		}
		public void setFile(File file) {
			this.file = file;
		}
		public int getFileid() {
			return fileid;
		}
		public void setFileid(int fileid) {
			this.fileid = fileid;
		}
		public String getFileFileName() {
			return fileFileName;
		}
		public void setFileFileName(String fileFileName) {
			this.fileFileName = fileFileName;
		}
		public String getFileContentType() {
			return fileContentType;
		}
		public void setFileContentType(String fileContentType) {
			this.fileContentType = fileContentType;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getIntroduction() {
			return introduction;
		}
		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}
		public String getTips() {
			return tips;
		}
		public void setTips(String tips) {
			this.tips = tips;
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

		public String getSwfpath() {
			return swfpath;
		}

		public void setSwfpath(String swfpath) {
			this.swfpath = swfpath;
		}

		public FileService getFileService() {
			return fileService;
		}

		public FileEntity getFileEntity() {
			return fileEntity;
		}

		public void setFileEntity(FileEntity fileEntity) {
			this.fileEntity = fileEntity;
		}

		public String getCategoryfirst() {
			return categoryfirst;
		}

		public void setCategoryfirst(String categoryfirst) {
			this.categoryfirst = categoryfirst;
		}

		public String getCategorysecond() {
			return categorysecond;
		}

		public void setCategorysecond(String categorysecond) {
			this.categorysecond = categorysecond;
		}

		public String getCategoryname() {
			return categoryname;
		}

		public void setCategoryname(String categoryname) {
			this.categoryname = categoryname;
		}

		public CategoryService getCategoryService() {
			return categoryService;
		}

		public void setCategoryService(CategoryService categoryService) {
			this.categoryService = categoryService;
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

		public FileScoreService getFileScoreService() {
			return fileScoreService;
		}

		public void setFileScoreService(FileScoreService fileScoreService) {
			this.fileScoreService = fileScoreService;
		}

		public int getUserscore() {
			return userscore;
		}

		public void setUserscore(int userscore) {
			this.userscore = userscore;
		}

		public String getDownloadname() {
			return downloadname;
		}

		public void setDownloadname(String downloadname) {
			this.downloadname = downloadname;
		}

		public void setInputStream1(InputStream inputStream1) {
			this.inputStream1 = inputStream1;
		}

		public List<FileEntity> getLikelylist() {
			return likelylist;
		}

		public void setLikelylist(List<FileEntity> likelylist) {
			this.likelylist = likelylist;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}

		public FileCommentService getFileCommentService() {
			return fileCommentService;
		}

		public void setFileCommentService(FileCommentService fileCommentService) {
			this.fileCommentService = fileCommentService;
		}

		public List<FileComment> getCommentlist() {
			return commentlist;
		}

		public void setCommentlist(List<FileComment> commentlist) {
			this.commentlist = commentlist;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public int getCommentuserid() {
			return commentuserid;
		}

		public void setCommentuserid(int commentuserid) {
			this.commentuserid = commentuserid;
		}

		public int getRowsperpage() {
			return rowsperpage;
		}

		public void setRowsperpage(int rowsperpage) {
			this.rowsperpage = rowsperpage;
		}

		public int getCpage() {
			return cpage;
		}

		public void setCpage(int cpage) {
			this.cpage = cpage;
		}

		public int getCpageNum() {
			return cpageNum;
		}

		public void setCpageNum(int cpageNum) {
			this.cpageNum = cpageNum;
		}

		public int getCdatanum() {
			return cdatanum;
		}

		public void setCdatanum(int cdatanum) {
			this.cdatanum = cdatanum;
		}

		public FileComment getFileComment() {
			return fileComment;
		}

		public void setFileComment(FileComment fileComment) {
			this.fileComment = fileComment;
		}

		public int getUserid1() {
			return userid1;
		}

		public void setUserid1(int userid1) {
			this.userid1 = userid1;
		}

		public FileDownLogService getFileDownLogService() {
			return fileDownLogService;
		}

		public void setFileDownLogService(FileDownLogService fileDownLogService) {
			this.fileDownLogService = fileDownLogService;
		}


		public FileCollectionService getFileCollectionService() {
			return fileCollectionService;
		}


		public void setFileCollectionService(FileCollectionService fileCollectionService) {
			this.fileCollectionService = fileCollectionService;
		}

}
