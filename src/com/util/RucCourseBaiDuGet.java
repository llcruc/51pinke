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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.service.impl.RucCourseServiceImpl;

public class RucCourseBaiDuGet {
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
	 * 获取课程信息
	 * @param coursename
	 * @return
	 */
	public String getCourseInfo(String coursename){
		String url = "http://baike.baidu.com/search/word?word="+coursename;
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet=new HttpGet(url);
		String courseinfo=null;
		try {
			HttpResponse response=httpclient.execute(httpGet);
			HttpEntity entity1=response.getEntity();
			if(entity1!=null){
				System.out.println("--------------------------------------");  
                System.out.println("Response content: ");  
                System.out.println("--------------------------------------");
                Document document=Jsoup.parse(EntityUtils.toString(entity1, "UTF-8"));
                Elements elements=document.select("div[class=card-summary-content]");
                if(elements.size()!=0){
                Element infoElement=elements.get(0);
                String info=infoElement.text();
                //System.out.println(info);
                courseinfo=info;
                }
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseinfo;
	}
    
	/**
	 * 获取单词条课程照片url
	 * @param coursename
	 * @return
	 */
	public String postform(String coursename) {
		String url = "http://baike.baidu.com/search/word?word="+coursename;
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet=new HttpGet(url);
		String imageurl=null;
		try {
			HttpResponse response=httpclient.execute(httpGet);
			HttpEntity entity1=response.getEntity();
			if(entity1!=null){
				System.out.println("--------------------------------------");  
                System.out.println("Response content: ");  
                System.out.println("--------------------------------------");
                Document document=Jsoup.parse(EntityUtils.toString(entity1, "UTF-8"));
                Elements elements=document.select("a[id=left-card-image-wrap]");
                if(elements.size()!=0){
                Element image=elements.get(0);
                String imagehref=image.select("img").attr("src");
                System.out.println(imagehref);
                imageurl=imagehref;
                }else {
					Elements elements2=document.select("a[class=lemmapic-mask use-picture-dialog]");
					if(elements2.size()!=0){
					Element image2=elements2.get(0);
					String imagehref2=image2.attr("href");
					System.out.println(imagehref2);
					imagehref2="http://baike.baidu.com"+imagehref2;
					HttpGet httpGet2=new HttpGet(imagehref2);
					HttpResponse response2=httpclient.execute(httpGet2);
					HttpEntity entity2=response2.getEntity();
					Document document2=Jsoup.parse(EntityUtils.toString(entity2, "UTF-8"));
					String imagehref3=document2.select("img[id=imgPicture]").get(0).attr("src");
					System.out.println(imagehref3);
					imageurl=imagehref3;
					}
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageurl;
	}
	
	/**
	 * 获取多词条课程照片url
	 * @param coursename
	 * @return
	 */
	public String getimage(String coursename){
		String url="http://baike.baidu.com/search/word?word="+coursename;
		HttpClient httpClient=new DefaultHttpClient();
		HttpGet httpGet=new HttpGet(url);
		String imgurl=null;
		try {
			HttpResponse response1=httpClient.execute(httpGet);
			HttpEntity entity1=response1.getEntity();
			if(entity1!=null){
				Document document1=Jsoup.parse(EntityUtils.toString(entity1));
				Elements elements=document1.select("a[href*=/subview");
				if (elements!=null) {
					Element element=elements.get(0);
					String url2=element.attr("href");
					//System.out.println(url2);
					HttpGet httpGet2=new HttpGet("http://baike.baidu.com"+url2);
					HttpResponse response2=httpClient.execute(httpGet2);
					HttpEntity entity2=response2.getEntity();
					if(entity2!=null){
						System.out.println("--------------------------------------");  
		                System.out.println("Response content: ");  
		                System.out.println("--------------------------------------");
		                Document document2=Jsoup.parse(EntityUtils.toString(entity2, "UTF-8"));
		                Elements elements2=document2.select("a[id=left-card-image-wrap]");
		                if(elements2.size()!=0){
		                Element image=elements2.get(0);
		                String imagehref=image.select("img").attr("src");
		                //System.out.println(imagehref);
		                imgurl=imagehref;
		                }else {
							Elements elements3=document2.select("a[class=lemmapic-mask use-picture-dialog]");
							if(elements3.size()!=0){
							Element image2=elements3.get(0);
							String imagehref2=image2.attr("href");
							//System.out.println(imagehref2);
							imagehref2="http://baike.baidu.com"+imagehref2;
							HttpGet httpGet3=new HttpGet(imagehref2);
							HttpResponse response3=httpClient.execute(httpGet3);
							HttpEntity entity3=response3.getEntity();
							Document document3=Jsoup.parse(EntityUtils.toString(entity3, "UTF-8"));
							String imagehref3=document3.select("img[id=imgPicture]").get(0).attr("src");
							//System.out.println(imagehref3);
							imgurl=imagehref3;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return imgurl;
	}
	
	/**
	 * 爬取百度教师信息（多词条）
	 * @param teachername
	 * @return
	 */
	public String getTeacherInfo(String teachername){
		String url="http://baike.baidu.com/search/word?word="+teachername;
		HttpClient httpClient=new DefaultHttpClient();
		HttpGet httpGet1=new HttpGet(url);
		String teacherinfo=null;
		try {
			HttpResponse response1=httpClient.execute(httpGet1);
			HttpEntity entity1=response1.getEntity();
			if(entity1!=null){
				System.out.println("--------------------------------------");  
                System.out.println("Response content: ");  
                System.out.println("--------------------------------------");
                Document document1=Jsoup.parse(EntityUtils.toString(entity1,"utf-8"));
                //System.out.println(document1.toString());
                Elements elements=document1.select("li[class=list-dot list-dot-paddingleft]");
                //System.out.println(elements.toString());
                for(int i=0;i<elements.size();i++){
                	Element element=elements.get(i);
                	//System.out.println(element.text());
                	if(element.text().contains("人民大学")){
                		//System.out.println(element.select("a").attr("href"));
                		String url2="http://baike.baidu.com"+element.select("a").attr("href");
                		//System.out.println(url2);
                		HttpGet httpGet2=new HttpGet(url2);
                		HttpResponse response2=httpClient.execute(httpGet2);
                		HttpEntity entity2=response2.getEntity();
                		Document document2=Jsoup.parse(EntityUtils.toString(entity2,"utf-8"));
                		Elements elements2=document2.select("div[class=card-summary-content]");
                		//System.out.println(elements2.text());
                		Elements elements3=document2.select("div[class=para]");
                		teacherinfo="";
                		for(int j=0;j<elements3.size();j++){
                			//elements3.get(j).select("a").html(",");
                			System.out.println(elements3.get(j).text().replaceAll("，", ","));
                			teacherinfo+="<p>"+elements3.get(j).text().replaceAll("，", ",")+"</p>";
                		}
                	}
                }
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return teacherinfo;
	}
	
	/**
	 * 多词条第二种
	 * @param teachername
	 * @return
	 */
	public String getTeacherInfo2(String teachername){
		String url="http://baike.baidu.com/search/word?word="+teachername;
		HttpClient httpClient=new DefaultHttpClient();
		HttpGet httpGet1=new HttpGet(url);
		String teacherinfo=null;
		try {
			HttpResponse response1=httpClient.execute(httpGet1);
			HttpEntity entity1=response1.getEntity();
			if(entity1!=null){
				Document document1=Jsoup.parse(EntityUtils.toString(entity1,"utf-8"));
				Elements elements=document1.select("div[class=polysemeBodyCon]");
				if(elements.size()!=0){
					Element element=elements.get(0);
					//System.out.println(element.toString());
					Elements elements2=element.select("li");
					for(int i=0;i<elements2.size();i++){
						if(elements2.get(i).text().contains("人民大学")){
							//System.out.println(elements2.get(i).select("a").attr("href"));
							String url2="http://baike.baidu.com"+elements2.get(i).select("a").attr("href");
							HttpGet httpGet2=new HttpGet(url2);
	                		HttpResponse response2=httpClient.execute(httpGet2);
	                		HttpEntity entity2=response2.getEntity();
	                		Document document2=Jsoup.parse(EntityUtils.toString(entity2,"utf-8"));
	                		//Elements elements3=document2.select("div[class=card-summary-content]");
	                		//System.out.println(elements2.text());
	                		Elements elements4=document2.select("div[class=para]");
	                		teacherinfo="";
	                		for(int j=0;j<elements4.size();j++){
	                			teacherinfo+="<p>"+elements4.get(j).text().replaceAll("，", ",")+"</p>";
	                			//System.out.println(teacherinfo);
	                		}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return teacherinfo;
	}
	
	/**
	 * 单词条
	 * @param teachername
	 * @return
	 */
	public String getTeacherInfo3(String teachername){
		String url="http://baike.baidu.com/search/word?word="+teachername;
		HttpClient httpClient=new DefaultHttpClient();
		HttpGet httpGet1=new HttpGet(url);
		String teacherinfo=null;
		try {
			HttpResponse response1=httpClient.execute(httpGet1);
			HttpEntity entity1=response1.getEntity();
			if(entity1!=null){
				Document document1=Jsoup.parse(EntityUtils.toString(entity1,"utf-8"));
				Elements elements=document1.select("div[class=para]");
				if(elements.size()!=0){
					Element element=elements.get(0);
					if(element.text().contains("人民大学")){
						//System.out.println(element.text());
						teacherinfo="";
						for(int i=0;i<elements.size();i++){
							teacherinfo+="<p>"+elements.get(i).text().replaceAll("，", ",")+"</p>";
						}
					}
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return teacherinfo;
	}
    
	public static void main(String[] args) {
		RucCourseBaiDuGet rucCourseImageGet=new RucCourseBaiDuGet();
		System.out.println(rucCourseImageGet.getTeacherInfo3("张俊岩"));
	}
	
}
