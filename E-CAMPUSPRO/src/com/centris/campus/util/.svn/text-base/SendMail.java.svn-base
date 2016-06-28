package com.centris.campus.util;

//this is a file used to send mails
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.centris.campus.admin.EmailContent;

public class SendMail {

	String FROM_ADDRESS = "donotreply@centrisinfotech.com";
	String SENDER_PASSWORD = "DoN%rP)987";

	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");

	private static String ClientURL = res.getString("ClientURL");

	/*
	 * String FROM_ADDRESS = "ranjith.sivan@spectrumconsultants.com"; String
	 * SENDER_PASSWORD = "ranjith1234";
	 */

	public synchronized String sendMail(String toAddress,
			InternetAddress[] ccList, String subject, String Bodymess)
			throws MessagingException, AddressException, Exception {

		String mailHost = JPropertyReader.getProperty("MAIL.SMTP.HOST");
		String mailPort = JPropertyReader.getProperty("MAIL.SMTP.PORT");
		String mailUser = JPropertyReader.getProperty("SENDER.MAIL.ID");
		String mailProtocal = JPropertyReader
				.getProperty("MAIL.TRANSPORT.PROTOCAL");
		String sendenName = JPropertyReader.getProperty("MAIL.SENDER.NAME");
		String startttlsEnable = JPropertyReader
				.getProperty("MAIL.SMTP.STARTTTLS.ENABLE");
		String mailPassword = JPropertyReader
				.getProperty("SENDER.MAIL.PASSWORD");
		String smtpAuth = JPropertyReader.getProperty("MAIL.SMTP.AUTH");
		FROM_ADDRESS = mailUser;
		SENDER_PASSWORD = mailPassword;

		System.out.println(" mailHost : " + mailHost);
		System.out.println(" mailPort : " + mailPort);
		System.out.println(" mailUser : " + mailUser);
		System.out.println(" mailProtocal : " + mailProtocal);
		System.out.println(" startttlsEnable : " + startttlsEnable);
		System.out.println(" mailPassword : " + mailPassword);
		System.out.println(" smtpAuth : " + smtpAuth);

		System.out.println("Starting send mail ");
		try {
			Properties props = System.getProperties();

			props.put("mail.transport.protocol", mailProtocal);
			props.put("mail.smtp.host", mailHost);
			props.put("mail.smtp.port", mailPort);
			props.put("mail.smtp.user", FROM_ADDRESS);
			props.put("mail.smtp.starttls.enable", startttlsEnable);
			props.put("mail.smtp.auth", smtpAuth);

			String smtpSslTrust = JPropertyReader
					.getProperty("MAIL.SMTP.SSL.TRUST");

			if (smtpSslTrust == null || smtpSslTrust.equalsIgnoreCase("")) {

			} else {
				System.out.println(" smtpSslTrust : " + smtpSslTrust);
				props.setProperty("mail.smtp.ssl.trust", smtpSslTrust);

			}

			Session mailSession = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(FROM_ADDRESS,
									SENDER_PASSWORD);
						}
					});

			// SecurityManager security = System.getSecurityManager();

			Authenticator auth = new SMTPAuthenticator();

			// Get a mail session and authenticate user
			Session session = Session.getDefaultInstance(props, auth);

			// Define a new mail message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sendenName + "<" + FROM_ADDRESS
					+ ">"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					toAddress));
			message.setRecipients(Message.RecipientType.CC, ccList);
			message.setSubject(subject);
			// Create a message part to represent the body text
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(Bodymess);

			// use a MimeMultipart as we need to handle the file attachments
			Multipart multipart = new MimeMultipart();

			// add the message body to the mime message
			multipart.addBodyPart(messageBodyPart);

			System.out.println();
			// Put all message parts in the message
			message.setContent(multipart);

			// Send the message

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(mailHost, FROM_ADDRESS, SENDER_PASSWORD);

			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("message sent");
		} catch (Exception e) {

			Logger loggger = Logger.getLogger(SendMail.class);
			loggger.info("Exception in sendMail part ." + e);
			e.printStackTrace();
			return null;
		}
		return "sent";
	}

	// mehtod to authenticate user
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(FROM_ADDRESS, SENDER_PASSWORD);
		}
	}

	// ************************************************************

	public synchronized String sendMail(EmailContent em) throws IOException {
		String result = null;
		try {
			String[] recipients = em.getMailids();
			String subject = em.getSubject();
			String message = em.getMessage();
			String ccString = "";
			for (int i = 1; i < recipients.length; i++) {
				if (recipients[i] != null && !"".equals(recipients[i])
						&& !"null".equalsIgnoreCase(recipients[i]))
					ccString = ccString + "," + recipients[i];
			}
			if (!ccString.equals("")) {
				ccString = ccString.substring(1);
			}
			InternetAddress[] ccList = InternetAddress.parse(ccString);
			result = sendMail(recipients[0], ccList, subject, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public synchronized String sendMailtoChild(String mailid, String username,
			String password) {
		String rst = null;
		try {

			EmailContent em = new EmailContent();
			String[] mails = { mailid };
			em.setMailids(mails);
			em.setSubject("Registration Confirmation Mail");
			em.setMessage("Greetings from E-CAMPUS PRO... \n\n"
					+ "Thank you for Registering with us\n"
					+ "Please use below Url to track / view your child activities in School \n\n"
					+ "URL : "
					+ ClientURL
					+ "\n\n"
					+ "Login Credentials are : \n\nUsername : "
					+ username
					+ "\nPassword : "
					+ password
					+ "\n\n"
					+ "Have a nice day"
					+ "\n\n"
					+ "Regards,\n"
					+ "E-CAMPUS PRO \n---------------------------------------------------\nThis is System generated mail, Please do not reply.");
			rst = new SendMail().sendMail(em);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rst;
	}

	public synchronized String sendMailtoTeacher(String mailid,
			String username, String password) {
		String rst = null;
		try {

			EmailContent em = new EmailContent();
			String[] mails = { mailid };
			em.setMailids(mails);
			em.setSubject("Registration Confirmation Mail");
			em.setMessage("Greetings from E-CAMPUS PRO... \n\n"
					+ "Thank you for Registering with us\n"
					+ "Please use below Url to track / view / update child activities in School \n\n"
					+ "URL : "
					+ ClientURL
					+ "\n\n"
					+ "Login Credentials are : \n\nUsername : "
					+ username
					+ "\nPassword : "
					+ password
					+ "\n\n"
					+ "Have a nice day"
					+ "\n\n"
					+ "Regards,\n"
					+ "E-CAMPUS PRO \n---------------------------------------------------\nThis is System generated mail, Please do not reply.");
			rst = new SendMail().sendMail(em);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rst;
	}

	public static void main(String[] args) {
		try {

			EmailContent em = new EmailContent();
			String[] mails = { "arul.k@centrisinfotech.com" };
			em.setMailids(mails);
			em.setSubject("Registration Confirmation Mail ");
			em.setMessage("Greetings from E-CAMPUS PRO... \n\n"
					+ "Thank you for Registering with us\n"
					+ "Please use below Url to track / view your child activities in School \n\n"
					+ "URL : "
					+ ClientURL
					+ "\n\n"
					+ "Login Credentials are : \n\nUsername : "
					+ "\nPassword : \n\n"
					+ "Have a nice day"
					+ "\n\n"
					+ "Regards,\n"
					+ "E-CAMPUS PRO \n---------------------------------------------------\nThis is System generated mail, Please do not reply.");
			String rst = new SendMail().sendMail(em);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}