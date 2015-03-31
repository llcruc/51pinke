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
	
	//��ȡ��ҳ����
	public static String getHtmlResourceByURL(String url, String encoding) {

		StringBuffer buffer = new StringBuffer();
		URL urlObj = null;
		URLConnection uc = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		try {
			// ������������
			urlObj = new URL(url);
			// ����������
			uc = urlObj.openConnection();
			// �����ļ�д����
			isr = new InputStreamReader(uc.getInputStream(), encoding);

			// ��������д����
			reader = new BufferedReader(isr);

			String line = null;
			// ѭ����ȡ������
			while ((line = reader.readLine()) != null) {
				buffer.append(line + "\n");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "��������ʧ��,�������������ַ����ȷ,�����ԣ�";
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
	 * ��ȡ�û��α�
	 * @param studentid �����˴��û���
	 * @param password �����˴�����
	 * @param year �γ�ѧ��
	 * @param term �γ�ѧ��
	 * @return
	 */
	public ArrayList<String> getCourse(String studentid,String password,String year,String term) {
		String url="https://cas.ruc.edu.cn/cas/login";
		String encoding="utf-8";
		Document document=Jsoup.parse(getHtmlResourceByURL(url, encoding));
		String codeid=document.select("input[name=lt]").val();
		
        ArrayList<String> arrayList=new ArrayList<String>();
		
        // ����Ĭ�ϵ�httpClientʵ��.    
		HttpClient httpclient = new DefaultHttpClient(); 
        // ����httppost    
        HttpPost httppost = new HttpPost("https://cas.ruc.edu.cn/cas/login");  
        // ������������    
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
                    
                    //��ȡ�α�html
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
                    
                    //����html
                    Document document3= Jsoup.parse(EntityUtils.toString(entity4, "UTF-8"));
                    Elements course=document3.select("td.cellContent");
                    for(int i=0;i<course.size();i++){
                    	if(i%7==0){
                    		System.out.println("��"+(i/7+1)+"�ڿ�");
                    	}
                    	String coursehtml=course.get(i).html();
                    	if(coursehtml.equals("")){
                    		arrayList.add(null);
                    	}else{
                    		//System.out.println(course.get(i).text());
                    		//String ctext=course.get(i).text();
                    		//System.out.println(ctext.substring(17,ctext.length()));
                    		//String coursename=ctext.substring(ctext.indexOf("��")+2,ctext.substring(17,ctext.length()).indexOf(" ")+17);
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
