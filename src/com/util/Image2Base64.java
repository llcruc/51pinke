package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Encoder;

public class Image2Base64 {
	
	public static String GetImageStr(String imgFilePath) {  
		byte[] data = null;  
		  
		try {  
		InputStream in = new FileInputStream(imgFilePath);  
		data = new byte[in.available()];  
		in.read(data);  
		in.close();  
		} catch (IOException e) {  
		e.printStackTrace();  
		}  
		BASE64Encoder encoder = new BASE64Encoder();  
		return encoder.encode(data);
		}

}
