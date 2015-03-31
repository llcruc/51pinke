package com.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 用户管理之发送邮件
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
	 * @param username 接收邮件者
	 * @param message 邮件内容
	 */
	public void sendmail(String username,String message){
		String host="smtp.163.com";
		String user="pinkeruc";
		String password="LIUlichao88";
		Properties props=new Properties();
		props.put("mail.smtp.host", host); // 指定SMTP服务器
        props.put("mail.smtp.auth", "true"); // 指定是否需要SMTP验证
        try {
			Session mailSession=Session.getDefaultInstance(props);
			Message message2=new MimeMessage(mailSession);;
			message2.setFrom(new InternetAddress("pinkeruc@163.com"));
			message2.addRecipient(Message.RecipientType.TO, new InternetAddress(username)); // 收件人
			message2.setSubject("您已经成功注册51pinke账号，请尽快激活账号");
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
