package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringHandler {
	public static String timeTostr(Date date){
		String strDate="";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		strDate=format.format(date);
		return strDate;
	}
	
	public static String getSerial(Date date){
		long mse1=date.getTime();
		SimpleDateFormat fm=new SimpleDateFormat("yyyyMMddHHmmss");
		date.setTime(mse1);
		String serials=fm.format(date);
		return serials;
	}
	
	public static Date StringToDate(String dateStr){
		DateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {
			date = dd.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String changehtml(String str){
		String change="";
		if(str!=null && !str.equals("")){
			change=str.replace("&", "&amp;");
			change=change.replace(" ","&nbsp;");
			change=change.replace("<","&lt;");
			change=change.replace(">","&gt;");
			change=change.replace("\"","&quot;");
			change=change.replace("\r\n","<br>");
		}
		return change;
	}
	
}
