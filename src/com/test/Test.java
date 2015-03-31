/*package com.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;























import sun.org.mozilla.javascript.internal.NativeArray;

import com.action.CourseAction;
import com.action.FileAction;
import com.action.UserAction;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.service.CategoryService;
import com.service.FileCollectionService;
import com.service.UserService;
import com.service.impl.FileServiceImpl;
import com.service.impl.RucCourseServiceImpl;
import com.service.impl.RucTeacherServiceImpl;
import com.spring.entity.FileCollection;
import com.spring.entity.FileEntity;
import com.spring.entity.RucCourse;
import com.spring.entity.RucTeacher;
import com.spring.entity.User;
import com.util.Image2Base64;
import com.util.Jmail;
import com.util.MD5Encrypt;
import com.util.RucCourseGetAll;
import com.util.RucCourseBaiDuGet;
import com.util.StringHandler;

public class Test {
	
	//ģ��request��response
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	
	//���Ŀγ̱��ʦ����
	public void updatecoursetable(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
		RucTeacherServiceImpl rucTeacherServiceImpl=(RucTeacherServiceImpl)context.getBean("ructeacherservice");
		List<RucCourse> list1=rucCourseServiceImpl.getAllCourse();
		for(int i=0;i<list1.size();i++){
			RucCourse rucCourse=new RucCourse();
			rucCourse=list1.get(i);
			int teacher=rucCourse.getTeacher();
			RucTeacher rucTeacher=new RucTeacher();
			if(rucTeacher!=null){
				int id=rucTeacher.getTeacherid();
			    rucCourse.setTeacher(id);
			    rucCourseServiceImpl.updateCourse(rucCourse);
			    System.out.println(teacher+">>>>>>>"+id+",��"+i+"��");
			}
		}
	}
	
	//�����ղط���ӿ�
	public void testcollectservice(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		FileCollectionService fileCollectionService=(FileCollectionService)context.getBean("filecollectionservice");
		List<FileCollection> list=fileCollectionService.findByUseridAndPage(26, 1, 10);
		System.out.println(list.size());
	}
	
	//����������
	public void chageFileType(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		FileServiceImpl fileServiceImpl=(FileServiceImpl)context.getBean("fileservice");
		List<FileEntity> list=fileServiceImpl.getfileByUser(26);
		for(int i=0;i<list.size();i++){
			FileEntity fileEntity=list.get(i);
			fileEntity.setFiletype(fileEntity.getFilename().substring(fileEntity.getFilename().lastIndexOf(".")+1,fileEntity.getFilename().length()));
			fileServiceImpl.updatefile(fileEntity);
		}
	}
	public void testCategory(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService categoryService=(CategoryService)context.getBean("categoryservice");
		String cid="10,93,1";
		System.out.println(categoryService.getNameById(cid));
		System.out.println(categoryService.getFirst(cid));
		System.out.println(categoryService.getSecond(cid));
	}

	
	public void test1(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		String [] s=context.getBeanDefinitionNames();
		for(String string:s){
			System.out.println(string);
		}
	}
	
    //����ע��
	public void test() throws IOException {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserAction userAction=(UserAction)context.getBean("useraction");
		userAction.setMail("274564873@qq.com");
		userAction.setPassword("LIUlichao88");
		System.out.println(userAction.registe());
	}
	
	//�����޸�����
	public void testupdate(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserAction userAction=(UserAction)context.getBean("useraction");
		userAction.setPassword("");
		userAction.setNewpassword("LIUlichao88");
		userAction.setMail("274564873@qq.com");
		System.out.println(userAction.updatepassword());
		
	}
	
	//����MD5
	public void testmd5(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		MD5Encrypt md5Encrypt=(MD5Encrypt)context.getBean("md5encrypt");
		String password="LIUlichao88";
		System.out.println(md5Encrypt.isValidInput(password));
		UserAction userAction=(UserAction)context.getBean("useraction");
		userAction.setMail("test");
		userAction.setPassword("LIUlichao88");
		
	}
	//���Ը�����Ϣ
	public void testupdateuserinfo(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserAction userAction=(UserAction)context.getBean("useraction");
		userAction.setMail("274564873@qq.com");
		userAction.setNickname("Flyaway");
		userAction.updateUserinfo();
		
	}
	
	//�����ʼ�����
	public void testmail(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Jmail mail=(Jmail)context.getBean("mail");
		mail.sendmail("pinkeruc@163.com", "�����˺��Ѿ��ɹ�ע�ᣡ�������Ӽ�� http://127.0.0.1:800/51pink");
		
	}
	
	//�����ļ��ϴ�
	public void testfileupload() throws IOException{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		FileAction fileAction=(FileAction)context.getBean("fileaction");
		fileAction.setFile(new File("C:/Users/Flyaway/Desktop/002564aab73e13c232fe49.jpg"));
	    fileAction.setFileContentType("imge/jpg");
	    fileAction.setFileFileName("123");
	    System.out.println(fileAction.uploadfile());
	}
	
	//�����ϴ��ļ�����ӿ�
	public void testfileservice(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		FileServiceImpl fileServiceImpl=(FileServiceImpl)context.getBean("fileservice");
		FileEntity fileEntity=new FileEntity();
		fileEntity.setFilename("2012�������໥�������ݷ����γ̷�������ϵ��ʽ.doc");
		fileEntity.setFilesize(47616);
		fileEntity.setFiletype("application/msword");
		fileEntity.setUserid(26);
		fileEntity.setUploadtime(StringHandler.timeTostr(new Date()));
		fileServiceImpl.uploadfile(fileEntity);
	}
	
	//���Ի�ȡ�ļ�id
	public void testgetfileid(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		FileServiceImpl fileServiceImpl=(FileServiceImpl)context.getBean("fileservice");
		String uploadtime="2014-10-28 15:12:07";
		int userid=26;
		System.out.println(fileServiceImpl.getfileByUserAndTime(userid, uploadtime).getFileid());
	}
	
	//��ȡ�����˴�γ�����
	public void RucGetCourse(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
		RucCourseGetAll rucCourseGetAll=new RucCourseGetAll();
		rucCourseGetAll.postForm(rucCourseServiceImpl);
	}
	
	//��ȡ�ٶȰٿƿγ���Ƭurl
	
	public void RucGetCourseImg(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
		List<RucCourse> list=rucCourseServiceImpl.getAllCourse();
		for(int i=0;i<list.size();i++){
			RucCourse rucCourse=new RucCourse();
			rucCourse=list.get(i);
			String coursename=rucCourse.getCoursename().replaceAll(" ", "");
			RucCourseBaiDuGet rucCourseImageGet=new RucCourseBaiDuGet();
			String courseimg=rucCourseImageGet.postform(coursename);
			System.out.println(courseimg);
			rucCourse.setCourseimg(courseimg);
			rucCourseServiceImpl.updateCourse(rucCourse);
			System.out.println(i+1);
		}
	}
	
	//��ȡ�ٶȰٿƿγ̽�����Ϣ����
	public void RucGetCourseInfo(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
		List<RucCourse> list=rucCourseServiceImpl.getAllCourse();
		for(int i=0;i<list.size();i++){
			RucCourse rucCourse=new RucCourse();
			rucCourse=list.get(i);
			String coursename=rucCourse.getCoursename().replaceAll(" ", "");
			if(rucCourse.getCourseinfo()==null){
			RucCourseBaiDuGet rucCourseImageGet=new RucCourseBaiDuGet();
			String courseinfo=rucCourseImageGet.getCourseInfo(coursename);
			System.out.println(courseinfo);
			rucCourse.setCourseinfo(courseinfo);
			rucCourseServiceImpl.updateCourse(rucCourse);
			}
			System.out.println(i+1);
		}
	}
	
	//���Ի�ȡcoursetimeid
	public void ruccoursetimeidtest(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
		RucCourse rucCourse=new RucCourse();
		rucCourse=rucCourseServiceImpl.getCourseByTimeId("2014121009554001");
		System.out.println(rucCourseServiceImpl.getCourseByTimeId("2014121009554001").getCoursename());
	}
	
	//���Կγ�info
	public void infotest(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseAction courseAction=(CourseAction)context.getBean("courseaction");
		courseAction.setCourseid("2014121002175001");
		courseAction.info();
	}
	
	//ת�ƽ�ʦ��������
	public void saveTeacher(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
		RucTeacherServiceImpl rucTeacherServiceImpl=(RucTeacherServiceImpl)context.getBean("ructeacherservice");
		List<RucCourse> list=rucCourseServiceImpl.getAllCourse();
		int k=1;
		for(int i=0;i<list.size();i++){
			RucCourse rucCourse=new RucCourse();
			rucCourse=list.get(i);
			RucTeacher rucTeacher=new RucTeacher();
			if(rucTeacher.getTeachername()==null){
				rucTeacherServiceImpl.saveTeacher(rucTeacher);
				k++;
				System.out.println(k);
			}
			System.out.println(i);
		}
	}
	
	//��ȡ�ٶȽ�ʦ��Ϣ(�������
	public void saveTeacherInfo1(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RucTeacherServiceImpl rucTeacherServiceImpl=(RucTeacherServiceImpl)context.getBean("ructeacherservice");
		List<RucTeacher> list=rucTeacherServiceImpl.getAllTeachers();
		RucCourseBaiDuGet rucCourseBaiDuGet=new RucCourseBaiDuGet();
		for(int i=0;i<list.size();i++){
			RucTeacher rucTeacher=new RucTeacher();
			rucTeacher=list.get(i);
			String teachername=rucTeacher.getTeachername().replaceAll(" ", "");
			String teacherinfo=rucCourseBaiDuGet.getTeacherInfo(teachername);
			rucTeacher.setTeacherinfo(teacherinfo);
			System.out.println(teacherinfo);
			rucTeacherServiceImpl.updateTeacher(rucTeacher);
			System.out.println(i);
		}
	}
	
	//��ȡ�ٶȽ�ʦ��Ϣ����������������ʾ������
	public void saveTeacherInfo2(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RucTeacherServiceImpl rucTeacherServiceImpl=(RucTeacherServiceImpl)context.getBean("ructeacherservice");
		List<RucTeacher> list=rucTeacherServiceImpl.getAllTeachers();
		RucCourseBaiDuGet rucCourseBaiDuGet=new RucCourseBaiDuGet();
		for(int i=0;i<list.size();i++){
			RucTeacher rucTeacher=new RucTeacher();
			rucTeacher=list.get(i);
			String teachername=rucTeacher.getTeachername().replaceAll(" ", "");
			if(rucTeacher.getTeacherinfo()==null){
			String teacherinfo=rucCourseBaiDuGet.getTeacherInfo2(teachername);
			rucTeacher.setTeacherinfo(teacherinfo);
			System.out.println(teacherinfo);
			rucTeacherServiceImpl.updateTeacher(rucTeacher);
			}
			System.out.println(i);
		}
	}
	
	//��ȡ�ٶȽ�ʦ��Ϣ����������
		public void saveTeacherInfo3(){
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			RucTeacherServiceImpl rucTeacherServiceImpl=(RucTeacherServiceImpl)context.getBean("ructeacherservice");
			List<RucTeacher> list=rucTeacherServiceImpl.getAllTeachers();
			RucCourseBaiDuGet rucCourseBaiDuGet=new RucCourseBaiDuGet();
			for(int i=0;i<list.size();i++){
				RucTeacher rucTeacher=new RucTeacher();
				rucTeacher=list.get(i);
				String teachername=rucTeacher.getTeachername().replaceAll(" ", "");
				if(rucTeacher.getTeacherinfo()==null){
				String teacherinfo=rucCourseBaiDuGet.getTeacherInfo3(teachername);
				rucTeacher.setTeacherinfo(teacherinfo);
				System.out.println(teacherinfo);
				
				rucTeacherServiceImpl.updateTeacher(rucTeacher);
				}
				System.out.println(i);
			}
		}
		
		//�γ�ת��base6
		public void downloadimg2bse64() throws IOException{
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
			List<RucCourse> list=rucCourseServiceImpl.getAllCourse();
			for(int i=0;i<list.size();i++){
				RucCourse rucCourse=new RucCourse();
				rucCourse=list.get(i);
				String path="D:/JavaWeb/ructime/51pink/WebRoot/data/course/images/";
				File file=new File(path,rucCourse.getCourseid()+".jpg");
				if(file.exists()){
					File file2=new File(path,rucCourse.getCoursetimeid()+".jpg");
					FileInputStream ins=new FileInputStream(file);
					FileOutputStream out=new FileOutputStream(file2);
					byte b[] = new byte[1024];
					int j = 0;
					while( (j = ins.read(b))!=-1){
					out.write(b,0,j);
					}
					ins.close();out.close();
					System.out.println(file2.getPath());
				}
			    System.out.println("������"+i);
			}
		}
		
		//��ʦ��Ƭת��
		@org.junit.Test
		public void teacherimg2base64(){
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			RucTeacherServiceImpl rucTeacherServiceImpl=(RucTeacherServiceImpl)context.getBean("ructeacherservice");
			List<RucTeacher> list=rucTeacherServiceImpl.getAllTeachers();
			int j=0;
			for(int i=0;i<list.size();i++){
				RucTeacher rucTeacher=new RucTeacher();
				rucTeacher=list.get(i);
				String path="D:/JavaWeb/ructime/51pink/WebRoot/data/teacher/images/"+rucTeacher.getTeachername()+".jpg";
				File file=new File(path);
				if(file.exists()){
				  String base64=Image2Base64.GetImageStr(path);
				  rucTeacher.setTeacherimg(base64);
				  rucTeacherServiceImpl.updateTeacher(rucTeacher);
				  System.out.println("ת����"+j+"��");
				}
				
			}
		}
		
		//���ؿγ�ͼƬ
		public void downloadimg(){
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
			List<RucCourse> list=rucCourseServiceImpl.getAllCourse();
			for(int i=0;i<list.size();i++){
				RucCourse rucCourse=new RucCourse();
				rucCourse=list.get(i);
				if(rucCourse.getCourseimg()!=null){
					String url=rucCourse.getCourseimg();
					HttpClient httpClient=new DefaultHttpClient();
					HttpGet httpGet=new HttpGet(url);
					try {
						HttpResponse response=httpClient.execute(httpGet);
						String filename=rucCourse.getCourseid()+"";
						String path="D:/JavaWeb/ructime/51pink/WebRoot/data/course/images/";
						File file=new File(path+filename+".jpg");
						if(!file.exists()){
							HttpEntity entity=response.getEntity();
							FileOutputStream out=new FileOutputStream(file);
							if(entity!=null){
								InputStream instream = entity.getContent();
								byte b[] = new byte[1024];
								int j = 0;
								while( (j = instream.read(b))!=-1){
								out.write(b,0,j);
								}
								System.out.println(filename+"�������");
								out.flush();
								out.close();
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				System.out.println(i);
			}
		}
		
		public void test2() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
			 WebClient wc = new WebClient();  
		        wc.getOptions().setJavaScriptEnabled(true); //����JS��������Ĭ��Ϊtrue  
		        wc.getOptions().setCssEnabled(false); //����css֧��  
		        wc.getOptions().setThrowExceptionOnScriptError(false); //js���д���ʱ���Ƿ��׳��쳣  
		        wc.getOptions().setTimeout(10000); //�������ӳ�ʱʱ�� ��������10S�����Ϊ0���������ڵȴ�  
		        HtmlPage page = wc.getPage("http://cq.qq.com/baoliao/detail.htm?294064"); 
		        String pageXml = page.asXml(); //��xml����ʽ��ȡ��Ӧ�ı�  
		        System.out.println(pageXml);
		  
		        *//**jsoup�����ĵ�*//*  
		        Document doc = Jsoup.parse(pageXml, "http://cq.qq.com");   
		        Element pv = doc.select("#feed_content span").get(1);  
		        System.out.println(pv.text());  
		        //Assert.assertTrue(pv.text().contains("���"));  
		  
		        System.out.println("Thank God!");  
		}
		
		*//**
		 * ���ؿγ�ͼƬ�ٶ�����
		 * @throws ClientProtocolException
		 * @throws IOException
		 *//*
		
		public void downloadimg2() throws ClientProtocolException, IOException{
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			RucCourseServiceImpl rucCourseServiceImpl=(RucCourseServiceImpl)context.getBean("courseservice");
			List<RucCourse> list=rucCourseServiceImpl.getAllCourse();
			for(int i=0;i<1;i++){
				RucCourse rucCourse=new RucCourse();
				rucCourse=list.get(i);
				if(rucCourse.getCourseimg()==null){
					WebClient wc = new WebClient(); 
					String url1="http://cq.qq.com/baoliao/detail.htm?294064";
					URL link=new URL(url1);
					WebRequest request=new WebRequest(link); 
					request.setCharset("UTF-8");
					
					wc.getCookieManager().setCookiesEnabled(false);//����cookie����
					wc.getOptions().setJavaScriptEnabled(true); //����JS��������Ĭ��Ϊtrue  
			        wc.getOptions().setCssEnabled(false); //����css֧��  
			        wc.getOptions().setThrowExceptionOnScriptError(false); //js���д���ʱ���Ƿ��׳��쳣  
			        wc.getOptions().setTimeout(10000); //�������ӳ�ʱʱ�� ��������10S�����Ϊ0���������ڵȴ�  
					
					HtmlPage rootPage = (HtmlPage) wc.getCurrentWindow().getEnclosedPage();
					HtmlPage rootPage1 = wc.getPage(url1);
			 		System.out.println(rootPage1.getUrl());
			 		System.out.println(rootPage1.asXml());
					
					HtmlPage page=null;
					page = wc.getPage(url1);
					String content=page.asXml();
					System.out.println(content);
					
					Document document=Jsoup.parse(content);
					Elements elements2=document.select("script");
					//System.out.println(elements2.toString());
					
					Element script=elements2.get(8);
					System.out.println(script.toString());
					
					
					System.out.println(url1);
					@SuppressWarnings("resource")
					HttpClient httpClient=new DefaultHttpClient();
					HttpGet httpGet=new HttpGet(url1);
					HttpResponse response=httpClient.execute(httpGet);
					HttpEntity entity=response.getEntity();
					Document document1=Jsoup.parse(EntityUtils.toString(entity),"utf-8");
					//System.out.println(document.toString());
					Elements elements=document1.select("script");
					//System.out.println(elements.toString());
					Element element=elements.get(7);
					//System.out.println(element.html());
					
					String script=element.html();
					ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
					Compilable compilable = (Compilable) engine;
					  //4��ʹ��NativeArray��ȡ����
					CompiledScript cScript;
					
					//System.out.println(script);
					
					 try {
						engine.eval(script);
						cScript = compilable.compile(script);
					     NativeArray na = (NativeArray) cScript.eval();
					     for (int j = 0; j < na.getLength(); j++) {
					         NativeArray nv = (NativeArray) na.get(i, null);
					         System.out.println(nv.get(0, null).toString() + " " + nv.get(1, null).toString());
					     }
					} catch (ScriptException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 System.out.println(engine.get("imgTempData"));
					 
					 try {
						JSONArray jsonArray=new JSONArray(engine.get("imgTempData").toString());
						for(int k=0;k<jsonArray.length();k++){
							JSONObject jsonObject=jsonArray.getJSONObject(k);
							System.out.println(jsonObject.get("queryEnc"));
						}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
					 
					 
					 
					
					if(elements.size()!=0){
					String url=elements.get(0).attr("src");
					System.out.println(url);
					HttpGet httpGet1=new HttpGet(url);
					try {
						HttpResponse response1=httpClient.execute(httpGet1);
						String filename=rucCourse.getCourseid()+"";
						String path="D:/JavaWeb/ructime/51pink/WebRoot/data/course/image/";
						File file=new File(path+filename+".jpg");
						if(!file.exists()){
							HttpEntity entity1=response1.getEntity();
							FileOutputStream out=new FileOutputStream(file);
							if(entity!=null){
								InputStream instream = entity1.getContent();
								byte b[] = new byte[1024];
								int j = 0;
								while( (j = instream.read(b))!=-1){
								out.write(b,0,j);
								}
								System.out.println(filename+"�������");
								out.flush();
								out.close();
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					}else {
						System.out.println("û��������ͼƬ");
					}
				}
				System.out.println(i);
			}
		}

}
*/