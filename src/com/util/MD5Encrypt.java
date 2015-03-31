package com.util;
/**
 * MD5加密算法
 * @author Flyaway
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt {
	public static String encode(String str){
		if(str==null){
			return null;
		}                                                            //字符串为空，返回null
		StringBuilder sb=new StringBuilder();                       //创建可变字符序列对象
		try {  
			MessageDigest code=MessageDigest.getInstance("MD5");     //算法信息摘要
			code.update(str.getBytes());                             
			byte [] bs=code.digest();                               //使用指定字节数组对摘要更新
			for(int i=0;i<bs.length;i++){
				int v=bs[i]&0xFF;
				if(v<16){
					sb.append(0);                                    //向可变字符序列添加0
				}
				sb.append(Integer.toHexString(v));                   //向可变字符序列添加转码后的字符串
				
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();                          //将得到的字节数组变成字符串返回
	}
	
	//校验是否存在非法字符
	public boolean isValidInput(String str){
		return str.matches("[a-z0-9A-Z]+");
	}

}
