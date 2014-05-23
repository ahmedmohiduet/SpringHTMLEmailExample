package com.mohi.common;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class HTMLMail
{
	private JavaMailSender mailSender;
	

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String from, String to, String subject, String msg) {
		try {

			MimeMessage message = mailSender.createMimeMessage();
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom(from);
			message.setSubject(subject);
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setText(msg, true);
			mailSender.send(message);
		} catch (MessagingException ex) {
			Logger.getLogger(HTMLMail.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
}
