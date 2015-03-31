package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.impl.RucCourseDaoImpl;
import com.service.RucCourseService;
import com.service.impl.RucCourseServiceImpl;
import com.spring.entity.RucCourse;

public class RucCourseGetAll {

public static String getHtmlResourceByURL(String url,String encoding){
		
		StringBuffer buffer=new StringBuffer();
		URL urlObj=null;
		URLConnection uc=null;
		InputStreamReader isr=null;
		BufferedReader reader=null;
		try {
			//建立网络连接
			urlObj = new URL(url);
			//打开网络连接
			uc=urlObj.openConnection();
			//建立文件写入流
			isr=new InputStreamReader(uc.getInputStream(),encoding);
			
			//建立缓冲写入流
			reader=new BufferedReader(isr);
			
			String line=null;
			//循环读取缓冲流
			while((line=reader.readLine())!=null){
				buffer.append(line+"\n");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "网络连接失败,或者您输入的网址不正确,请重试！";
		}finally{
			try {
				if(isr!=null){
				    isr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}     
		
		return buffer.toString();
	}

public void postForm(RucCourseServiceImpl rucCourseServiceImpl) {  
	String url="https://cas.ruc.edu.cn/cas/login";
	String encoding="utf-8";
	Document document=Jsoup.parse(getHtmlResourceByURL(url, encoding));
	String codeid=document.select("input[name=lt]").val();
	
	System.out.println(codeid);
	
	
    // 创建默认的httpClient实例.    
	HttpClient httpclient = new DefaultHttpClient(); 
    // 创建httppost    
    HttpPost httppost = new HttpPost("https://cas.ruc.edu.cn/cas/login");  
    // 创建参数队列    
    List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
    formparams.add(new BasicNameValuePair("username", "2012202661"));  
    formparams.add(new BasicNameValuePair("password", "500235199504022677"));
    formparams.add(new BasicNameValuePair("lt", codeid)); 
    formparams.add(new BasicNameValuePair("loginErrCnt", "0")); 
    UrlEncodedFormEntity uefEntity;  
    try {  
        uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
        httppost.setEntity(uefEntity);  
        System.out.println("executing request " + httppost.getURI()); 
        HttpContext localContext = new BasicHttpContext();
        HttpResponse response = httpclient.execute(httppost,localContext);  
        try {  
            HttpEntity entity = response.getEntity();  
            if (entity != null) {  
                System.out.println("--------------------------------------");  
                System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                System.out.println("--------------------------------------");
                
                //打开查询表单页面第一步
                String url2="http://portal.ruc.edu.cn/idc/education/selectcourses/resultquery/ResultQueryAction.do?method=forwardAllQueryXkjg";
                HttpGet httpget = new HttpGet(url2);
                HttpResponse response2 = httpclient.execute(httpget,localContext);
                HttpEntity entity2 = response2.getEntity();
                System.out.println("--------------------------------------");  
                //System.out.println("Response content: " + EntityUtils.toString(entity2, "UTF-8"));  
                System.out.println("--------------------------------------");
                
                //获取一个id号
                Document document2=Jsoup.parse(EntityUtils.toString(entity2, "UTF-8"));
                String url3=document2.select("a").get(0).attr("href");
                System.out.println(url3);
                
                //打开查询表单页面第二步
                HttpGet httpget2 = new HttpGet(url3);
                HttpResponse response3=httpclient.execute(httpget2);
                HttpEntity entity3=response3.getEntity();
                System.out.println("--------------------------------------");  
                System.out.println("Response content: "+ EntityUtils.toString(entity3, "UTF-8"));  
                System.out.println("--------------------------------------");
                
                //发送查询post
                for(int j=1;j<=240;j++){
                HttpPost httpPost2=new HttpPost("http://portal.ruc.edu.cn/idc/education/selectcourses/resultquery/ResultQueryAction.do");
                List<NameValuePair> params=new ArrayList<NameValuePair>();
                if(j==1){
                params.add(new BasicNameValuePair("condition_xnd", "2014-2015"));
                params.add(new BasicNameValuePair("condition_xq", "1"));
                params.add(new BasicNameValuePair("isNeedInitSQL", "true"));
                params.add(new BasicNameValuePair("method", "allJxb"));
                params.add(new BasicNameValuePair("xnd", "2014-2015"));
                params.add(new BasicNameValuePair("xq", "1"));
                params.add(new BasicNameValuePair("pageNo", "239"));
                }else {
                	params.add(new BasicNameValuePair("condition_xnd", "2014-2015"));
                    params.add(new BasicNameValuePair("condition_xq", "1"));
                    params.add(new BasicNameValuePair("method", "allJxb"));
                    params.add(new BasicNameValuePair("pageNo", j+""));
                    params.add(new BasicNameValuePair("pageSize", "10"));
                    params.add(new BasicNameValuePair("xnd", "2014-2015"));
                    params.add(new BasicNameValuePair("xq", "1"));
				}
                uefEntity=new UrlEncodedFormEntity(params,"UTF-8");
                httpPost2.setEntity(uefEntity);
                HttpResponse response4=httpclient.execute(httpPost2);
                HttpEntity entity4=response4.getEntity();
                System.out.println("返回提交表单--------------------------------------");  
                //System.out.println("Response content: "+EntityUtils.toString(entity4, "UTF-8"));  
                System.out.println("--------------------------------------");
                
                //获取页面的每一条记录
                Document document3=Jsoup.parse(EntityUtils.toString(entity4, "UTF-8"));
                Elements course=document3.select("a[href*=/idc]");
                Elements course2=document3.select("tr[id=ECNUTR]");
                for(int i=0;i<course2.size();i++){
                	//System.out.println(course2.get(i));
                	System.out.println("coursetimeid:"+course2.get(i).select("a[href*=/idc]").first().text());
                	System.out.println("courseid:"+course2.get(i).select("td").get(4).text());
                	System.out.println("coursename:"+course2.get(i).select("a[href*=/idc]").last().text());
                	System.out.println("teacher:"+course2.get(i).select("td").get(8).text());
                	System.out.println("time:"+course2.get(i).getElementById("detail").text());
                	System.out.println("--------------------------------------");
                	
                	int courseid=Integer.parseInt(course2.get(i).select("td").get(4).text());
                	String coursetimeid=course2.get(i).select("a[href*=/idc]").first().text();
                	String coursename=course2.get(i).select("a[href*=/idc]").last().text();
                	String teacher=course2.get(i).select("td").get(8).text();
                	String time=course2.get(i).getElementById("detail").text();
                	int coursecredit=Integer.parseInt(course2.get(i).select("td").get(6).text());
                	String coursecategory=course2.get(i).select("td").get(7).text();
                	String classname=course2.get(i).select("td").get(3).text();
                	RucCourse ruccourse=new RucCourse();
                	ruccourse.setCourseid(courseid);
                	ruccourse.setCoursetimeid(coursetimeid);
                	ruccourse.setCoursename(coursename);
                	ruccourse.setCoursetime(time);
                	//ruccourse.setTeacher(teacher);
                	ruccourse.setClassname(classname);
                	ruccourse.setCoursecredit(coursecredit);
                	ruccourse.setCoursecategory(coursecategory);
                	try {
                		rucCourseServiceImpl.saveCourse(ruccourse);
                		System.out.println(j*10+i);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
                	
                }
                
                }
            }  
        
    }catch (Exception e) {
		// TODO: handle exception
    	e.printStackTrace();
	}
    }catch (Exception e) {
		// TODO: handle exception
    	e.printStackTrace();
	}
}


}
