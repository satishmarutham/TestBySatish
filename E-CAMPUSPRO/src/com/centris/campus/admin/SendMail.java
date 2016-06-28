package com.centris.campus.admin;

import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	
	
	public static String senderName = "LATHEEF"; 
	public static String hostName = "smtp.gmail.com";    
	public static String fromMailId = ""; 
	public static String password = "";        
	public static String authentication = "true";
	public static String portNumber = "25";           
	public static String protocol = "smtp";  
	
	public void sendMail(String email,EmailContent em){
		
		System.out.println("----sendmail is calling----------");
		String to = email;
		String subject ="LATHEEF PRIMARY SCHOOL";
		String body = em.getContent()+"\n"+"Your Username is "+em.getUsername()+" & Password is "+em.getPassword();
		String filename = "D:\\jaga\\abc.txt";
		Properties props = null;
		Transport t = null;
		MimeMessage message = null;
		try {
			props = System.getProperties();
			props.put("mail.smtp.starttls.enable", authentication);
			props.put("mail.smtp.host", hostName);
			props.put("mail.smtp.port", portNumber);
			props.put("mail.smtp.auth", authentication);
			props.put("mail.smtp.user", fromMailId);
			props.put("mail.smtp.password", password);
			javax.mail.Session mailSession = javax.mail.Session.getInstance(props, null);			
			message = new MimeMessage(mailSession);
			
			BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            
			Calendar today = Calendar.getInstance();
			message.setSentDate(today.getTime());
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));					
			message.setFrom(new InternetAddress(senderName + "<" + fromMailId + ">"));
					
			message.setSubject(subject);
			message.saveChanges();
			t = mailSession.getTransport(protocol);
			t.connect(hostName, fromMailId, password);
			t.sendMessage(message, message.getAllRecipients());
			if (t != null) {
				System.out.println("Email Sent Successfully");
			}
		} catch (Exception e) {
			System.out.println("Exception in MailSend() :"+ e);					

		}

	}

}
