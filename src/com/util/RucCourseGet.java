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

public class RucCourseGet {
	
	//获取网页内容
	public static String getHtmlResourceByURL(String url, String encoding) {

		StringBuffer buffer = new StringBuffer();
		URL urlObj = null;
		URLConnection uc = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		try {
			// 建立网络连接
			urlObj = new URL(url);
			// 打开网络连接
			uc = urlObj.openConnection();
			// 建立文件写入流
			isr = new InputStreamReader(uc.getInputStream(), encoding);

			// 建立缓冲写入流
			reader = new BufferedReader(isr);

			String line = null;
			// 循环读取缓冲流
			while ((line = reader.readLine()) != null) {
				buffer.append(line + "\n");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "网络连接失败,或者您输入的网址不正确,请重试！";
		} finally {
			try {
				if (isr != null) {
					isr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return buffer.toString();
	}
    
	/**
	 * 获取用户课表
	 * @param studentid 数字人大用户名
	 * @param password 数字人大密码
	 * @param year 课程学年
	 * @param term 课程学期
	 * @return
	 */
	public ArrayList<String> getCourse(String studentid,String password,String year,String term) {
		String url="https://cas.ruc.edu.cn/cas/login";
		String encoding="utf-8";
		Document document=Jsoup.parse(getHtmlResourceByURL(url, encoding));
		String codeid=document.select("input[name=lt]").val();
		
        ArrayList<String> arrayList=new ArrayList<String>();
		
        // 创建默认的httpClient实例.    
		HttpClient httpclient = new DefaultHttpClient(); 
        // 创建httppost    
        HttpPost httppost = new HttpPost("https://cas.ruc.edu.cn/cas/login");  
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("username", studentid));  
        formparams.add(new BasicNameValuePair("password", password));
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
                    String url2="http://portal.ruc.edu.cn/idc/education/selectcourses/schedulequery/ScheduleQueryAction.do?method=forwardQueryStudentSchedule&isNeedInitSQL=true";
                    HttpGet httpget = new HttpGet(url2);
                    HttpResponse response2 = httpclient.execute(httpget,localContext);
                    HttpEntity entity2 = response2.getEntity();
                    Document document2= Jsoup.parse(EntityUtils.toString(entity2, "UTF-8"));
                    String url3=document2.select("a").get(0).attr("href");
                    System.out.println("url3"+url3);
                    HttpGet httpget2 = new HttpGet(url3);
                    HttpResponse response3=httpclient.execute(httpget2);
                    HttpEntity entity3=response3.getEntity();
                    System.out.println("--------------------------------------");  
                    System.out.println("Response content1: "+ EntityUtils.toString(entity3, "UTF-8"));  
                    System.out.println("--------------------------------------");
                    
                    //获取课表html
                    List<NameValuePair> para=new ArrayList<NameValuePair>();
                    para.add(new BasicNameValuePair("method", "studentScheduleXX"));
                    para.add(new BasicNameValuePair("isNeedInitSQL", "true"));
                    para.add(new BasicNameValuePair("condition_xnd", year));
                    para.add(new BasicNameValuePair("condition_xq", term));
                    para.add(new BasicNameValuePair("condition_xh", studentid));
                    HttpPost httpPost2=new HttpPost("http://portal.ruc.edu.cn/idc/education/selectcourses/schedulequery/ScheduleQueryAction.do");
                    uefEntity = new UrlEncodedFormEntity(para, "UTF-8");
                    httpPost2.setEntity(uefEntity);
                    HttpResponse response4=httpclient.execute(httpPost2);
                    HttpEntity entity4=response4.getEntity();
                    
                    //解析html
                    Document document3= Jsoup.parse(EntityUtils.toString(entity4, "UTF-8"));
                    Elements course=document3.select("td.cellContent");
                    for(int i=0;i<course.size();i++){
                    	if(i%7==0){
                    		System.out.println("第"+(i/7+1)+"节课");
                    	}
                    	String coursehtml=course.get(i).html();
                    	if(coursehtml.equals("")){
                    		arrayList.add(null);
                    	}else{
                    		//System.out.println(course.get(i).text());
                    		//String ctext=course.get(i).text();
                    		//System.out.println(ctext.substring(17,ctext.length()));
                    		//String coursename=ctext.substring(ctext.indexOf("程")+2,ctext.substring(17,ctext.length()).indexOf(" ")+17);
                    		String coursetimeid=course.get(i).select("input[name=jxbstr]").val();
                    		System.out.println(coursetimeid);
                    		arrayList.add(coursetimeid);
                    	}
                    }
                }  
            
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
        	return null;
		}
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
        	return null;
		}
		return arrayList;

	}
	

}
