package com.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * �û�����֮�����ʼ�
 * @author Flyaway
 *
 */
public class Jmail {
	
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 
	 * @param username �����ʼ���
	 * @param message �ʼ�����
	 */
	public void sendmail(String username,String message){
		String host="smtp.163.com";
		String user="pinkeruc";
		String password="LIUlichao88";
		Properties props=new Properties();
		props.put("mail.smtp.host", host); // ָ��SMTP������
        props.put("mail.smtp.auth", "true"); // ָ���Ƿ���ҪSMTP��֤
        try {
			Session mailSession=Session.getDefaultInstance(props);
			Message message2=new MimeMessage(mailSession);;
			message2.setFrom(new InternetAddress("pinkeruc@163.com"));
			message2.addRecipient(Message.RecipientType.TO, new InternetAddress(username)); // �ռ���
			message2.setSubject("���Ѿ��ɹ�ע��51pinke�˺ţ��뾡�켤���˺�");
			message2.setText(message);
			message2.saveChanges();
			Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, password);
            transport.sendMessage(message2, message2.getAllRecipients());
            transport.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
