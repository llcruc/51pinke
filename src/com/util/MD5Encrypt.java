package com.util;
/**
 * MD5�����㷨
 * @author Flyaway
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt {
	public static String encode(String str){
		if(str==null){
			return null;
		}                                                            //�ַ���Ϊ�գ�����null
		StringBuilder sb=new StringBuilder();                       //�����ɱ��ַ����ж���
		try {  
			MessageDigest code=MessageDigest.getInstance("MD5");     //�㷨��ϢժҪ
			code.update(str.getBytes());                             
			byte [] bs=code.digest();                               //ʹ��ָ���ֽ������ժҪ����
			for(int i=0;i<bs.length;i++){
				int v=bs[i]&0xFF;
				if(v<16){
					sb.append(0);                                    //��ɱ��ַ��������0
				}
				sb.append(Integer.toHexString(v));                   //��ɱ��ַ��������ת�����ַ���
				
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();                          //���õ����ֽ��������ַ�������
	}
	
	//У���Ƿ���ڷǷ��ַ�
	public boolean isValidInput(String str){
		return str.matches("[a-z0-9A-Z]+");
	}

}
